package com.vet.main.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.vet.main.emp.EmpVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler{@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
	String rememberId = request.getParameter("remember-id");
	EmpVO empVO = (EmpVO)authentication.getPrincipal();
	empVO.setPassword(null);
	log.info("REMEMBER-ID {} \n :::  Auth {} ", rememberId, authentication);
	log.info("Authentication {}", authentication);
	log.info("URL {}", request.getRequestURL());	
	if(rememberId != null && rememberId.equals("ok")) {
		Cookie cookie = new Cookie("rememberId", empVO.getEmpNo());
		
		cookie.setHttpOnly(true);
		cookie.setPath("/");     //같은 도메인 내에서 어느 URL에서 사용 가능한가 적용
														 // setDomain("naver.com") 이라면 mail.naver.com 같은 subDomain에서 접근 가능하게 설정
		cookie.setMaxAge(600);
		response.addCookie(cookie);
		log.info("Make Cookie");
	}else {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("rememberId")) {
				cookie.setMaxAge(0);
				cookie.setPath("/");  //삭제 할 때 쿠키를 만들때의 path와 동일하지 않으면 삭제가 안됨!!
				response.addCookie(cookie);
				log.info("Delete Cookie");
				break;
			}
		}
	}
	
	response.sendRedirect("/");
}

}
