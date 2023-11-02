package com.vet.main.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;
	

	
}
