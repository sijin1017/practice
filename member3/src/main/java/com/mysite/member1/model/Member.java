package com.mysite.member1.model;

import java.util.Date;

public class Member {
	private Long id;
	private String name;
	private String email;
	private String password;
	private Date registerDate;
	
	public Member(String name, String email, String password, Date registerDate) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.registerDate = registerDate;
	}

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }

	public Date getRegisterDate() { return registerDate; }
	public void setRegisterDate(Date registerDate) { this.registerDate = registerDate; }
}
