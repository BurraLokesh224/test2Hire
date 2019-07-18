package com.letsgettin.QBarter.tes2hire.message.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.letsgettin.QBarter.tes2hire.model.Register;

public class ForgetPassword {

	@NotBlank
	@Email
	private String email;
	private int otp;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}
		
	
	
}
