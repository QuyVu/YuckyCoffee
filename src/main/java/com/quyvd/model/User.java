package com.quyvd.model;

public class User {

	private String userName;
	private String password;
	private String role;
	private boolean enabled;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String password, String role, boolean enabled) {
		this.userName = name;
		this.password = password;
		this.role = role;
		this.enabled = enabled;
	}
	
	public User(String name, String password, String role) {
		this.userName = name;
		this.password = password;
		this.role = role;
	}

	public User(String name, String role) {
		this.userName = name;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String toString() {
		return "User: " + this.getUserName() + ", " + this.getRole() + ", " + this.isEnabled();
	}

}
