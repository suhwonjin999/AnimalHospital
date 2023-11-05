package com.vet.main.emp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class EmailController {

	private final EmailService emailService;
	
	@PostMapping("/sendMail")
	public ResponseEntity sendMail() {
		EmailMessageVO emailMessageVO = EmailMessageVO.builder()
				.to("tpdms981@gmail.com")
				.subject("동물병원에서 보내는 메일입니다.")
				.message("테스트 본문")
				.build();
		emailService.sendMail(emailMessageVO);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
