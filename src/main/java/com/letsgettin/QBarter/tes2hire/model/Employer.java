package com.letsgettin.QBarter.tes2hire.model;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Employer {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

 	@NotBlank

	@Size(min = 3)
	private String company_Name;

	@NotBlank

	@Size(min = 3)
	private String contact_PersonName;

	@NotBlank

	@Size(min = 3)
	private String GST_Number;

	@NotBlank

	@Size(min = 3)
	private String TIN_Number;

	@Lob
	private Byte[] company_Logo;

	@NotBlank

	@Size(min = 3)
	private String website;

	@NotBlank

	@Size(min = 6)
	private String address;

	@NotBlank
	private String city;

	@NotBlank
	private String state;

	@NotBlank
	private String pincode;

	@NotBlank

	@Size(min = 10, max = 14)
	private String country;

	@OneToOne(cascade = CascadeType.ALL)

	@JoinColumn(name = "register_id")
	private Register register;

	public Employer() {

	}

	public Employer(Long id, @NotBlank @Size(min = 3) String company_Name,
			@NotBlank @Size(min = 3) String contact_PersonName, @NotBlank @Size(min = 3) String gST_Number,
			@NotBlank @Size(min = 3) String tIN_Number, Byte[] company_Logo, @NotBlank @Size(min = 3) String website,
			@NotBlank @Size(min = 6) String address, @NotBlank String city, @NotBlank String state,
			@NotBlank String pincode, @NotBlank @Size(min = 10, max = 14) String country, Register register) {
		super();
		this.id = id;
		this.company_Name = company_Name;
		this.contact_PersonName = contact_PersonName;
		GST_Number = gST_Number;
		TIN_Number = tIN_Number;
		this.company_Logo = company_Logo;
		this.website = website;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.register = register;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany_Name() {
		return company_Name;
	}

	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}

	public String getContact_PersonName() {
		return contact_PersonName;
	}

	public void setContact_PersonName(String contact_PersonName) {
		this.contact_PersonName = contact_PersonName;
	}

	public String getGST_Number() {
		return GST_Number;
	}

	public void setGST_Number(String gST_Number) {
		GST_Number = gST_Number;
	}

	public String getTIN_Number() {
		return TIN_Number;
	}

	public void setTIN_Number(String tIN_Number) {
		TIN_Number = tIN_Number;
	}

	public Byte[] getCompany_Logo() {
		return company_Logo;
	}

	public void setCompany_Logo(Byte[] company_Logo) {
		this.company_Logo = company_Logo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

}
