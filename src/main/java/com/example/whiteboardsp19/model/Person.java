package com.example.whiteboardsp19.model;


public class Person {
	private Integer id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String role;
	public Person(Integer id, String password, String username, String firstname, String lastname, String role) {
		this.id = id;
		this.password = password;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}

