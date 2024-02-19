package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ParentException {
   
	@ExceptionHandler(NotAuthorisedException.class)
	public ResponseEntity<SystemException> AuthNotFoundHandler(NoHandlerFoundException noHandlerFoundException,WebRequest req)  {
			
	
	SystemException syExp =new SystemException(LocalDateTime.now(), noHandlerFoundException.getMessage(), req.getDescription(false));
	
		return new ResponseEntity<>(syExp,HttpStatus.BAD_REQUEST);
					
	}
	
	@ExceptionHandler(InvalidException.class)
	public ResponseEntity<SystemException> InvalidHandler(NoHandlerFoundException noHandlerFoundException,WebRequest req)  {
			
	
	SystemException syExp =new SystemException(LocalDateTime.now(), noHandlerFoundException.getMessage(), req.getDescription(false));
	
		return new ResponseEntity<>(syExp,HttpStatus.BAD_REQUEST);
					
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<SystemException> UserErrorHandler(NoHandlerFoundException noHandlerFoundException,WebRequest req)  {
			
	
	SystemException syExp =new SystemException(LocalDateTime.now(), noHandlerFoundException.getMessage(), req.getDescription(false));
	
		return new ResponseEntity<>(syExp,HttpStatus.BAD_REQUEST);
					
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<SystemException> productNotFoundHandler(NoHandlerFoundException noHandlerFoundException,WebRequest req)  {
			
	
	SystemException syExp =new SystemException(LocalDateTime.now(), noHandlerFoundException.getMessage(), req.getDescription(false));
	
		return new ResponseEntity<>(syExp,HttpStatus.BAD_REQUEST);
					
	}
	
}
