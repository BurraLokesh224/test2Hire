
package com.letsgettin.QBarter.tes2hire.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity

@Table(name = "candidate")

public class Candidate {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank

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

	@NotBlank // @Enumerated(EnumType.STRING) private String gender; private
	String gender;

	@NotBlank

	@Size(min = 3)
	private String dateOfBirth;

	@NotBlank

	@Size(min = 6)
	private String address;

	@NotBlank

	@Size(min = 6, max = 100)
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

	@OneToOne(cascade = CascadeType.ALL)

	@JoinColumn(name = "register_id")
	private Register register;

	/*
	 * @OneToOne(cascade = CascadeType.ALL, mappedBy = "candidate", fetch =
	 * FetchType.LAZY) private Sslc sslc;
	 * 
	 * @OneToOne(cascade = CascadeType.ALL, mappedBy = "candidate", fetch =
	 * FetchType.LAZY) private Intermediate intr;
	 */

	public Candidate(@NotBlank @Size(min = 3) String firstName, @NotBlank @Size(min = 3) String lastName,

			@NotBlank @Size(min = 3) String fathersName, @NotBlank @Size(min = 3) String fathersOccupation,

			@NotBlank String gender, @NotBlank @Size(min = 3) String dateOfBirth,

			@NotBlank @Size(min = 6) String address, @NotBlank @Size(min = 6, max = 100) String aadharNumber,

			@NotBlank @Size(min = 10, max = 10) String panNumber, @NotBlank String city, @NotBlank String state,

			@NotBlank String pincode, @NotBlank @Size(min = 10, max = 14) String phoneNumber,

			@NotBlank @Size(min = 10, max = 14) String alternateNumber) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.fathersName = fathersName;
		this.fathersOccupation = fathersOccupation;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.phoneNumber = phoneNumber;
		this.alternateNumber = alternateNumber;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getFathersOccupation() {
		return fathersOccupation;
	}

	public void setFathersOccupation(String fathersOccupation) {
		this.fathersOccupation = fathersOccupation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternatephoneNumber(String alternatephoneNumber) {
		this.alternateNumber = alternatephoneNumber;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	/*
	 * public Sslc getSslc() { return sslc; }
	 * 
	 * public void setSslc(Sslc sslc) { this.sslc = sslc; }
	 * 
	 * public Intermediate getIntr() { return intr; }
	 * 
	 * public void setIntr(Intermediate intr) { this.intr = intr; }
	 */

}
