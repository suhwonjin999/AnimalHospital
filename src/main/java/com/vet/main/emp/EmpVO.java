package com.vet.main.emp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmpVO implements UserDetails{

	//emp
	private String empNo;
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
	private String role;
	
	//department
	private String deptName;
	private Long parentNo;
	private Long depth;
	
	private String passwordCheck;
	
	private Boolean enabled;
	private List<RoleVO> roleVOs;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();

		for(RoleVO roleVO: roleVOs) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return empNo;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		// 계정의 만료 여부 
		// true 만료 안됨, 
		// false 만료됨, 로그인 안됨
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// 계정 잠김 여부
		// true     : 계정 잠기지 않음
		// false    : 계정 잠김, 로그인 안됨
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 만료 여부
		// true     : 만료 안됨
		// false    : 만료 됨, 로그인 안됨
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 계정 잠김 여부
		// true     : 계정 잠기지 않음
		// false    : 계정 잠김, 로그인 안됨
		return true;
	}
}