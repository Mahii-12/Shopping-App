package com.example.demo.dto;

import java.time.LocalDate;

public class UsersResponse {

	 private String fullName;
	 private String username;
	 private String email;
	 private LocalDate dateOfBirth;
	 private String address;
	 
	 public UsersResponse() {}

	/**
	 * @param fullName
	 * @param username
	 * @param email
	 * @param dateOfBirth
	 * @param address
	 */
	public UsersResponse(String fullName, String username, String email, LocalDate dateOfBirth, String address) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dateOfBirth
	 */
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	 
	 
}
