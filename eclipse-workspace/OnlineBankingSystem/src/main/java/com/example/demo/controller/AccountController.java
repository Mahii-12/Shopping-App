package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AccountResponse;
import com.example.demo.entity.Account;
import com.example.demo.exception.AccountException;
import com.example.demo.service.AccountServiceImpl;

@RestController
@RequestMapping("/account/")
public class AccountController {

	@Autowired
	private AccountServiceImpl aService;
	
	
	
	@PostMapping("/a_create")
	public ResponseEntity<AccountResponse> Caccount(@RequestBody Account account) throws AccountException{
		AccountResponse res=aService.cAccount(account);
		res.setUsername(res.getUsername());
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
	
	@GetMapping("/allAcounts")
	public ResponseEntity<List<AccountResponse>> GAllAccounts(){
		List<AccountResponse> res=aService.gAllAccount();
		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<AccountResponse> Gid(@PathVariable("Id") Long accountId) throws AccountException{
		AccountResponse res=aService.gAccountId(accountId);
		return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{Id}")
	public ResponseEntity<String> DeleteId(@PathVariable("Id") Long accountId) throws AccountException{
		String d=aService.dAccountId(accountId);
		return new ResponseEntity<>(d, HttpStatus.ACCEPTED);
	}
	
}
