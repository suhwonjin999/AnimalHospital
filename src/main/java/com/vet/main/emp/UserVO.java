package com.vet.main.emp;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserVO implements UserDetails{

	private EmpVO empVO;
	
	public UserVO(EmpVO empVO) {
		this.empVO = empVO;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		
		
		return null;
	}

	@Override
	public String getPassword() {
		
		return empVO.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return empVO.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
