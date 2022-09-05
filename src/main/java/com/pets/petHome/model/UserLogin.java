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
	private String passwordLogin;
	private String tokenLoginString;

	public String getNameLogin() {
		return nameLogin;
	}

	public void setNameLogin(String nameLogin) {
		this.nameLogin = nameLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public String getTokenLoginString() {
		return tokenLoginString;
	}

	public void setTokenLoginString(String tokenLoginString) {
		this.tokenLoginString = tokenLoginString;
	}

	
	
}
