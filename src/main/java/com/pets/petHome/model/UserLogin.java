package com.pets.petHome.model;

import org.springframework.beans.factory.annotation.Autowired;

public class UserLogin {
	
	/*private String userLoginType;
	
	@Autowired
	private Customer customerModel;
	
	void setUserLoginType(String userType) {
		if(userType == "Customer") {
			 
		}
	}*/
	
	private String nameLogin;
	private String emailLogin;
	private String passwordLogin;
	private String tokenLogin;

	public String getNameLogin() {
		return nameLogin;
	}

	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
	}
	

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public String getTokenLogin() {
		return tokenLogin;
	}

	public void setTokenLogin(String tokenLogin) {
		this.tokenLogin = tokenLogin;
	}

	
	
}
