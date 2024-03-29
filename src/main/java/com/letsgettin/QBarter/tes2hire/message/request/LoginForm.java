package com.letsgettin.QBarter.tes2hire.message.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginForm {
	@NotBlank
	@Size(min = 3, max = 60)
	private String emailId;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	public String getemailId() {
		return emailId;
	}

	public void setemailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}