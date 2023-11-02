package com.vet.main.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@PostMapping("/send")
	public ResponseEntity<Object> send(EmpVO empVO){
		
		//이메일 발신될 데이터
		
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo("{tpdms981@naver.com}"); // 받는 사람 이메일 주소
		simpleMailMessage.setSubject("{스프링 메일 테스트입니당.}"); // 이메일 주소
		simpleMailMessage.setText("스프링으로 보내는 메일 \n"+"줄 바꾸기는 이렇게"); //메일 내용
		
		
		//이메일 발신
		javaMailSender.send(simpleMailMessage);
		
		//결과 반환
		return ResponseEntity.ok(true);
	}
}
