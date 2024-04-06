package com.example.demo.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ParentExceptionHandler {

	@ExceptionHandler(UsersExceptions.class)  
	 public ResponseEntity<MyErrorDetails> usersExceptionHandler(UsersExceptions userException,WebRequest req){
	        
			MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), userException.getMessage(), req.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	}
	 
	 @ExceptionHandler(OrderException.class)  
	 public ResponseEntity<MyErrorDetails> projectExceptionHandler(OrderException orderException,WebRequest req){
	        
			MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), orderException.getMessage(), req.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	} 
	 
	 @ExceptionHandler(ProductException.class)  
	 public ResponseEntity<MyErrorDetails> taskExceptionHandler(ProductException productException,WebRequest req){
	        
			MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), productException.getMessage(), req.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	} 
}
