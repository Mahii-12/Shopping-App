package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDTO;
import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;


@Service
public class TransactionServiceImpl implements TransactionsService{
	
	@Autowired
	private AccountRepository aRepository;
	
	@Override
	public String deposit(Long accountId, double amount) {
		Account account = aRepository.findById(accountId).get();
		if(!aRepository.existsById(accountId)) {
			return "Account not found";
		}
		else {
	        account.setBalance(account.getBalance() + amount);
	        aRepository.save(account);	
	        return "Successfully Completed Your Transaction !";
		}
	}

	
	@Override
	public String MYWithdraw(Long accountId, double amount) {
        Account account = aRepository.findById(accountId).get();
		if(!aRepository.existsById(accountId)) {
               return "Account not found";
		}
		else {
			double cbal=account.getBalance();
			if(cbal<amount) {
				return "Insufficient funds";
			}
			else {
				account.setBalance(cbal - amount);
				aRepository.save(account);
				return "Successfully Completed Your Transaction !";
			}
		}
	}

	
	@Override
	public String Mytransfer(Long sourceAccountId, Long targetAccountId, double amount) {
		Account fromAccount = aRepository.findById(sourceAccountId).get();
        if(!aRepository.existsById(sourceAccountId)) {
        	return "Account not found";
        }
        Account toAccount = aRepository.findById(targetAccountId).get();
        if(!aRepository.existsById(targetAccountId)) {
        	return "Account not found";
        }    

        double fromBalance = fromAccount.getBalance();
        if (fromBalance < amount) {
           return "Insufficient funds for transfer";
        }
        else {
	        fromAccount.setBalance(fromBalance - amount);
	        toAccount.setBalance(toAccount.getBalance() + amount);
	
	        aRepository.save(fromAccount);
	        aRepository.save(toAccount);
	        return "Successfully Completed Your Transaction !";
        }
    }

}
