package com.vet.main.emp;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmpVO {

	//emp
	private String userName;
	private String password;
	private String name;
	private String email;
	private String phone;
	private Date hireDate;
	private String randomPw;
	private String fileName;
	private String originalFileName;
	private Long positionNo;
	private String deptNo;
	private String state;
	private Date birth;
	
	
	//position
	private String positionName;
	
	//department
	private String deptName;
	private Long parentNo;
	private Long depth;
	
	private String passwordCheck;
}