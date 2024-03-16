package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountResponse;
import com.example.demo.entity.Account;
import com.example.demo.entity.Users;
import com.example.demo.exception.AccountException;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.UserRepository;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepository aRepository;
	
	@Autowired
	private UserRepository uRepository;

	@Override
	public AccountResponse cAccount(Account account) throws AccountException{
		Optional<Account> id=aRepository.findById(account.getAccountId());
		
		if(id.isPresent()) {
			throw new AccountException(id + " Is Exist!");
		}
		else {
			Users username=uRepository.findByUsername(account.getUsername());
			account.setUsers(username);
	        aRepository.save(account);
	        AccountResponse ac = mapToAccountResponse(account);
	        return ac;
		}
	}


	@Override
	public List<AccountResponse> gAllAccount() {
		List<Account> all=aRepository.findAll();
		List<AccountResponse> res=new ArrayList<>();
		for(Account a:all) {
			AccountResponse rr=new AccountResponse();
			rr.setAccountType(a.getAccountType());
			rr.setUsername(a.getUsers());
			res.add(rr);
		}
		return res;
	}

	@Override
	public AccountResponse gAccountId(Long accountId) throws AccountException{
		if(aRepository.existsById(accountId)) {
			Account a=aRepository.findById(accountId).get();
			AccountResponse res=mapToAccountResponse(a);
			return res;
		}
		else {
			throw new AccountException(accountId + " Is not exist!");
		}
	}

	@Override
	public String dAccountId(Long accountId) throws AccountException{
		if(aRepository.existsById(accountId)) {
			aRepository.deleteById(accountId);
			throw new AccountException(accountId + " Is Successfully Deleted!");
		}
		else {
		    throw new AccountException(accountId + " Is Invalid Id !");	
		}
	}

	public AccountResponse mapToAccountResponse(Account account) {
		AccountResponse new_ac=new AccountResponse();
		new_ac.setAccountType(account.getAccountType());
		new_ac.setUsername(new_ac.getUsername());
		return new_ac;
	}
	
	
}
