package com.astrotalk.model;

public class Login {
    
    private String mobile;
    
    private String password;
	public String getMobile() {
		return mobile;
	}
	public void setUsername(String mobile) {
		this.mobile = mobile;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Login(String mobile, String password) {
		super();
		this.mobile = mobile;
		this.password = password;
	}
	public Login() {
		super();
	}
    
    
}