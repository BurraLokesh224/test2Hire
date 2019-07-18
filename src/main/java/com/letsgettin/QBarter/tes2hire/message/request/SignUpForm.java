package com.letsgettin.QBarter.tes2hire.message.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignUpForm {

	@NotBlank
	@Size(max = 60)
	@Email
	private String emailId;
	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	private Set<String> role;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole() {
		return this.role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

}