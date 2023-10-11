package com.vet.main.emp;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmpVO {

	private Long empno;
	private String password;
	private String name;
	private String email;
	private String phone;
	private Date hiredate;
	private String deptno;
	private Long roleno;
	
}
