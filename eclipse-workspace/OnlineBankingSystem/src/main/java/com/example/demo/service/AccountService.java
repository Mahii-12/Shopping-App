package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.AccountResponse;
import com.example.demo.entity.Account;
import com.example.demo.exception.AccountException;

public interface AccountService {

	public AccountResponse cAccount(Account account) throws AccountException;
	public List<AccountResponse> gAllAccount();
	public AccountResponse gAccountId(Long accountId) throws AccountException ;
	public String dAccountId(Long accountId)throws AccountException;
}
