package com.example.demo.service;

import com.example.demo.dto.LoginDTO;

public interface TransactionsService {
	
	public String deposit(Long accountId, double amount);
	public String MYWithdraw(Long accountId, double amount);
	public String Mytransfer(Long sourceAccountId, Long targetAccountId, double amount);

}
