package com.vet.main.login;

import java.util.ArrayList;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailConfig {

//	private JavaMailSender mailSender;
//	
//	public MailConfig(JavaMailSender mailSender) {
//		super();
//		this.mailSender = mailSender;
//	}
//	
//	public void sendErrorMail(String message) {
//		ArrayList<String> toUserList = new ArrayList<>();
//		
//		toUserList.add("tpdms981@naver.com"); // 메일을 보낼 상대방들을 List에 담는다.
//		
//		int  listSize = toUserList.size();
//		
//		SimpleMailMessage smm = new SimpleMailMessage();
//		
//		// 수신자 설정
//		smm.setTo((String[]) toUserList.toArray(new String[listSize]));
//		
//		// 메일 제목 설정
//		smm.setSubject("안녕하세요, 동물병원입니다.");
//		
//		// 메일 내용 설정
//		
//		smm.setText("사원번호는 2023009 비밀번호는 123456 입니다. 입력 후 비밀번호를 변경해주세요.");
//		
//		mailSender.send(smm);
//	}
}
