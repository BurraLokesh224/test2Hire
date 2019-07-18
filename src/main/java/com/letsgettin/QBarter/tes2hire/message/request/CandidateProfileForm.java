
package com.letsgettin.QBarter.tes2hire.message.request;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.letsgettin.QBarter.tes2hire.model.Register;

/*import com.letsgettin.QBarter.tes2hire.model.Intermediate;
import com.letsgettin.QBarter.tes2hire.model.Sslc;*/

public class CandidateProfileForm {

	@Size(min = 3)
	private String firstName;

	@NotBlank

	@Size(min = 3)
	private String lastName;

	@NotBlank

	@Size(min = 3)
	private String fathersName;

	@NotBlank

	@Size(min = 3)
	private String fathersOccupation;

	@NotBlank // @Enumerated(EnumType.STRING) private String gender;

	@Size(max = 7)
	private String gender;

	@NotBlank

	@Size(min = 3)
	private String dateOfBirth;

	@NotBlank

	@Size(min = 6)
	private String address;

	@NotBlank

	@Size(min = 6, max = 14)
	private String aadharNumber;

	@NotBlank

	@Size(min = 10, max = 10)
	private String panNumber;

	@NotBlank
	private String city;

	@NotBlank
	private String state;

	@NotBlank
	private String pincode;

	@NotBlank

	@Size(min = 10, max = 14)
	private String phoneNumber;

	@NotBlank

	@Size(min = 10, max = 14)
	private String alternateNumber;

	private Register register;

	/*
	 * private Sslc sslc; private Intermediate intermediate;
	 */

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFathersName() {
		return fathersName;
	}

	public String getFathersOccupation() {
		return fathersOccupation;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public String getGender() {
		return gender;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPincode() {
		return pincode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public Register getRegister() {
		return register;
	}

	/*
	 * public Sslc getSslc() { return sslc; }
	 * 
	 * public Intermediate getIntermediate() { return intermediate; }
	 */

}
