package com.vet.main.login;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.vet.main.emp.EmpService;


@Configuration //스프링 환경 세팅을 돕는 어노테이션
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Autowired
	private EmpService empService;
	
	//암호를 인코딩하거나 인코딩된 암호와 사용자가 입력한 암호가 같은지 확인할때 사용
	@Bean
	public PasswordEncoder encoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    return passwordEncoder;

	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		DataSource dataSource = null;
//		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
//		userDetailsManager.setUsersByUsernameQuery("SELECT empNo, password, enabled FROM EMP WHERE empNo = ?");
//		userDetailsManager.setAuthoritiesByUsernameQuery("SELECT E.empNo, P.role FROM EMP E INNER JOIN POSITION P ON E.POSITIONNO = P.POSITIONNO WHERE empNo=?");
//		userDetailsManager.setCreateUserSql("INSERT INTO EMP (empNo, password, enabled) VALUES (NULL, ?, ?)");
//		return userDetailsManager;
//	}
	
	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		
		return web -> web
				.ignoring()
				.antMatchers("/assets/**")
				.antMatchers("/fonts/**")
				.antMatchers("/html/**")
				.antMatchers("/js/**")
				.antMatchers("/libs/**")
				.antMatchers("/scss/**")
				.antMatchers("/tasks/**")
				.antMatchers("../WEB-INF/views/layout/**") 
				.antMatchers("../resources/images/**")
				;
	}
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity)throws Exception{
		httpSecurity
					.cors()
					.and()
					.csrf()
					.disable()
				.authorizeRequests()
					.antMatchers("/emp/login").permitAll() 
					.antMatchers("/").permitAll() 
//					.antMatchers("/emp/empUpdate").hasRole("USER")  
				/* .anyRequest().authenticated() */
					.and()
				.formLogin()
					.loginPage("/emp/login")
					.usernameParameter("empNo")    //username대신 사용하는 parameter명
					.successHandler(successHandler)//인증에 성공할 경우 요청할 URL
					.failureUrl("/emp/login?error=true&message=LoginFail") //인증에 실패했을 경우 요청할 URL
					.permitAll()
					.and()
				.logout()
					.logoutUrl("/emp/logout")
					.addLogoutHandler(getLogoutAdd())
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.permitAll();

		
		return httpSecurity.build();
					
	}
	
	private SecurityLogoutHandler getLogoutHandler() {
		return new SecurityLogoutHandler();
	}
	
	private SecurityLogoutAdd getLogoutAdd() {
		return new SecurityLogoutAdd();
	}
	
}

	

	
