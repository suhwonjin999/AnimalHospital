package com.vet.main.emp;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
public class EmailService {

	private final JavaMailSender javaMailSender;
	
	public void sendMailTest() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setTo("tpdms981@naver.com");
		simpleMailMessage.setSubject("[동불병원] 임시비밀번호 발급");
		simpleMailMessage.setText("안녕하세요, 임시비밀번호는 animal입니다. 로그인 후 변경해주세요.");
		
		javaMailSender.send(simpleMailMessage);
	}
}
