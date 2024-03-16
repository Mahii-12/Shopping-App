package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TransactionServiceImpl;

@RestController
@RequestMapping("/transaction/")
public class TransactionController {
	
	@Autowired
	private TransactionServiceImpl tService;
	
	@PostMapping("/deposit")
	public ResponseEntity<String> CDeposit(@RequestParam Long accountId, @RequestParam double amount) {
		String mes=tService.deposit(accountId, amount);
		return new ResponseEntity<>(mes, HttpStatus.ACCEPTED);
	}

	@PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam Long accountId, @RequestParam double amount) {
        String mes=tService.MYWithdraw(accountId, amount);
        return new ResponseEntity<>(mes, HttpStatus.ACCEPTED);
    }
	
	@PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam Long fromAccountId, @RequestParam Long toAccountId, @RequestParam double amount){
        String mes=tService.Mytransfer(fromAccountId, toAccountId, amount);
        return new ResponseEntity<>(mes, HttpStatus.ACCEPTED);
    }
}
