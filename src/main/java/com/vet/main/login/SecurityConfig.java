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
	
	@Autowired
	private EmpService empService;
	
	
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
				.antMatchers("/resources/images/*").permitAll()
				.antMatchers("/**").hasAnyRole("ADMIN", "USER")
				.antMatchers("/emp/empUpdate").hasRole("ADMIN")
				.and()
			.formLogin()
				.loginPage("/emp/login")
				.successHandler(successHandler)
				.failureUrl("/emp/login")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/emp/logout")
				.logoutSuccessUrl("/emp/login")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()
				.and()
				.rememberMe()
					.tokenValiditySeconds(60)
					.key("rememberKey")
					.userDetailsService(empService)
					.authenticationSuccessHandler(successHandler)
					.and()
					
				.sessionManagement();
				
		return httpSecurity.build();
					
	}

	
}

	

	
