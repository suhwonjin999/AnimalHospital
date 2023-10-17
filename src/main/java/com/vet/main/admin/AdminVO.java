package com.vet.main.admin;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminVO {

	//emp
	private Long empNo;
	private String password;
	private String name;
	private String email;
	private String phone;
	private Date hireDate;
	private String randomPw;
	private String filenName;
	private String originalFileName;
	private Long positionNo;
	private String deptNo;
	private String state;
	
	
	//position
	private String positionName;
	
	//department
	private String deptName;
	private Long parentNo;
	private Long depth;
}
