package com.letsgettin.QBarter.tes2hire.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "registers", uniqueConstraints = { @UniqueConstraint(columnNames = { "emailID" }) })
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NaturalId
	@NotBlank
	@Email
	private String emailId;

	@NotBlank
	@Size(min = 6, max = 100)
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "register_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> role = new HashSet<>();

	
	public Long getId() {
		return id;
	}

	public Register() {

	}

	public Register(@NotBlank @Email String emailId, @NotBlank @Size(min = 6, max = 100) String password) {
		super();

		this.emailId = emailId;
		this.password = password;

	}

	public void setId(Long id) {
		this.id = id;
	}

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

	/*
	 * public Candidate getCandidate() { return candidate; }
	 * 
	 * public void setCandidate(Candidate candidate) { this.candidate = candidate; }
	 */

	public Set<Role> getRole() {
		return role;
	}

	public void setRoles(Set<Role> role) {
		this.role = role;
	}

}