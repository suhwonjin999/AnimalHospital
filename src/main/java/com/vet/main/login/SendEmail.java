package com.vet.main.login;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

	@Autowired
	private JavaMailSender sender;
	
	// 메일발송
	
		public boolean sendEmail(String toAddress, String subject, String body) {
			System.out.println(toAddress+"보낼주소");
			
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			
			try {
				helper.setTo(toAddress); // 보낼 주소
				helper.setSubject(subject); // 제목
				helper.setText(body); // 내용
			} catch (MessagingException e) {
				e.printStackTrace();
				System.out.println(toAddress+"에게 메일전송 실패");
				return false;
			}
			sender.send(message);
			System.out.println(toAddress+"에게 메일전송 성공");
			
			return true;
			
		}
	
}
