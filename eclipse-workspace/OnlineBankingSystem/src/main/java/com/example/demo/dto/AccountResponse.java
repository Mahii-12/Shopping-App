package com.example.demo.dto;

import com.example.demo.entity.Users;



public class AccountResponse {
	
	private String accountType;
    private Users username;
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the username
	 */
	public Users getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(Users username) {
		this.username = username;
	}
    
    

}
