package com.vet.main.login;

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
	
	//암호를 인코딩하거나 인코딩된 암호와 사용자가 입력한 암호가 같은지 확인할때 사용
	@Bean
	public PasswordEncoder encoder() {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    return passwordEncoder;

	}
	
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
				;
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.cors()
			.and()
			.csrf()
			.disable()
			.authorizeHttpRequests()
				.antMatchers("/emp/*").hasAnyRole("ADMIN", "USER")
				.and()
			.formLogin()
				.loginPage("/emp/login")
				.defaultSuccessUrl("/")
				.failureUrl("/emp/login")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/emp/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll();

		
		return httpSecurity.build();
					
	}

	
}

	

	
