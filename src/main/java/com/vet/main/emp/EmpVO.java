package com.vet.main.emp;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmpVO {

	//emp (회원테이블)
	//사원번호 Long empNo을 String username 으로 변경
	private String username;
	private String password;
	private String empName;
	private String email;
	private String phone;
	private Date hireDate;
	private String fileName;
	private String originalFileName;
	private Long positionNo;
	private Long deptNo;
	private String state;
	private Date birth;
	private Long randomPw;
	
	
	//position
	private String positionName;
	
	//department
	private String deptName;
	private Long parentNo;
	private Long depth;
	
	
}
