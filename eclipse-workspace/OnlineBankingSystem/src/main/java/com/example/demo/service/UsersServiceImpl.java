package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import com.example.demo.configurations.TokenManager;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UsersResponse;
import com.example.demo.entity.Users;
import com.example.demo.exception.UsersException;
import com.example.demo.repository.UserRepository;

@Service
public class UsersServiceImpl implements UsersServices{
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenManager jwtTokenProvider;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public String login(LoginDTO loginDto) {

	        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	                loginDto.getUsername(),
	                loginDto.getPassword()
	        ));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtTokenProvider.generateToken(authentication);
            return token;
	    }

	@Override
	public UsersResponse cUsers(Users user) throws UsersException{
		Optional<Users> byFullName=uRepository.getByFullName(user.getFullName());
		if(byFullName.isPresent()) {
			throw new UsersException(byFullName + " Is Already Exists !");
		}
		else {
			uRepository.save(user);
			UsersResponse gUser = mapToUsersResponse(user);
			return gUser;
		}
	}

	@Override
	public List<UsersResponse> gAllusers() {
	   List<Users> aUsers=uRepository.findAll();
	   List<UsersResponse> uResponse=new ArrayList<>();
	   for(Users u : aUsers) {
		   UsersResponse dto=new UsersResponse();
		   dto.setFullName(u.getFullName());
		   dto.setEmail(u.getEmail());
		   dto.setUsername(u.getUsername());
		   dto.setDateOfBirth(u.getDateOfBirth());
		   dto.setAddress(u.getAddress());
		   uResponse.add(dto);
	   }
	   return uResponse;
	}

	@Override
	public UsersResponse gUsersId(Long userId, LoginDTO logins) throws UsersException{
		if(!uRepository.findById(userId).isPresent()) {
			 throw new UsersException(userId + " Is not Exist!");
		}
		else {
			Users user=uRepository.findByUsername(logins.getUsername());		
			if (passwordEncoder.matches(logins.getPassword(), user.getPassword())) {
	            Users nUser = uRepository.findById(userId).get();
	            UsersResponse gUser = mapToUsersResponse(nUser);
	            return gUser;
	        }
			else {
				throw new UsersException("Invalid password");
			}
		}
	}

	@Override
	public Users uUsers(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String dUsersId(Long userId) {
		if(uRepository.existsById(userId)) {
			uRepository.deleteById(userId);
			return userId + " Is Successfully Deleted! ";
		}
		else {
			return userId + " Is Not Exists! ";
		}
	}
	
	private UsersResponse mapToUsersResponse(Users user) {
	     UsersResponse response = new UsersResponse();
	     response.setFullName(user.getFullName());
	     response.setUsername(user.getUsername());
	     response.setEmail(user.getEmail());
	     response.setDateOfBirth(user.getDateOfBirth());
	     response.setAddress(user.getAddress());
	     return response;
	}

}
