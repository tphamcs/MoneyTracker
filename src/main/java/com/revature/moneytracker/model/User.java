package com.revature.moneytracker.model;

public class User {
	
	private int id;
	private String name; //instance
	private String username;
	private String role;
	private String email;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String role) {
		this.name = name;
		this.role = role;
	}
	
	public User(String name, String role, String email, String username) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
}
