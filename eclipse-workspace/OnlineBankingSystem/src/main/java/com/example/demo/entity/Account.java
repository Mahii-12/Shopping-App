package com.example.demo.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.example.demo.entity.Users;

@Entity
@Table(name="Account")
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private String accountType;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore 
    private Users users;
    private String username;
    
    public Account() {}

	/**
	 * @param accountId
	 * @param accountType
	 * @param balance
	 * @param username
	 */
	public Account(Long accountId, String accountType, double balance, Users users) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
		this.users = users;
	}

	/**
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

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
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the username
	 */
	public Users getUsers() {
		return users;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsers(Users users) {
		this.users = users;
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

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance
				+ ", users=" + users + "]";
	}
    
    

}
