package com.vet.main.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Login Fail");
		System.out.println("LocalizedMessage : "+exception.getLocalizedMessage());
		System.out.println("Cause : "+exception.getCause());
		System.out.println("Class : "+exception.getClass().toString().substring(exception.getClass().toString().lastIndexOf(".")+1));
		System.out.println("Message : "+exception.getMessage());
		
		String errorClass = exception.getClass().toString().substring(exception.getClass().toString().lastIndexOf(".")+1);
		String message="";
		switch (errorClass) {
		case "BadCredentialsException":
				message="비번이 틀림";
			break;
		case "InternalAuthenticationServiceException":
			message="아이디가 없음";
		break;
		case "AuthenticationCredentialNotFoundException":
			message="인증이 안됌";
		break;	
		case "LockedException":
			message="계정 잠김";
		break;			
		case "DisabledException":
			message="휴면 계정";
		break;	
		case "AccountExpiredException":
			message="계정 유효기간 만료";
		break;
		case "CredentialExpiredException":
			message="비밀번호 유효기간 만료";
		break;
		default:
			message="다시 시도";
			break;
		}
	}

	
	
}
