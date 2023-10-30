package com.vet.main.emp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmpInfo {

	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String phone;
	
//	private String positionName;
//	private Long positionNo;
//	
//	private String deptName;
//	private Long deptNo;
//	
//	private String state;
//	
	
}
