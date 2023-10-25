package com.vet.main.emp;

public enum Role{
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");
	
	final private String name;
	
	private Role(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
}
