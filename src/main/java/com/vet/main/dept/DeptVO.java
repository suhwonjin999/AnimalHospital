package com.vet.main.dept;

import java.sql.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeptVO {

	private String username;
	private String password;
	private String empName;
	private String email;
	private String phone;
	private Long positionNo;
	private String deptNo;
	private Date hireDate;
	private String state;
	private Date birth;
	private String positionName;
	private String deptName;
	private Long parentNo;
	private Long depth;
	
	private List<DeptVO> children;
	
}
