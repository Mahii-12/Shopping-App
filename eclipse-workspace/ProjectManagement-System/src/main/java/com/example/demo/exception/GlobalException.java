package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.entity.MyErrorDetails;

@ControllerAdvice
public class GlobalException {

//	 @ExceptionHandler(Exception.class)
//	 public ResponseEntity<Object> handleGlobalException(Exception ex) {
//	        // Customize the response for all types of exceptions
//	        // You can log the error or return a custom error message
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                             .body("An unexpected error occurred: " + ex.getMessage());
//	 }
//	 
	 @ExceptionHandler(UsersException.class)  
	 public ResponseEntity<MyErrorDetails> usersExceptionHandler(UsersException userException,WebRequest req){
	        
			MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), userException.getMessage(), req.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	}
	 
	 @ExceptionHandler(ProjectException.class)  
	 public ResponseEntity<MyErrorDetails> projectExceptionHandler(UsersException userException,WebRequest req){
	        
			MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), userException.getMessage(), req.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	} 
	 
	 @ExceptionHandler(TaskException.class)  
	 public ResponseEntity<MyErrorDetails> taskExceptionHandler(UsersException userException,WebRequest req){
	        
			MyErrorDetails myErr = new MyErrorDetails(LocalDateTime.now(), userException.getMessage(), req.getDescription(false));
			
			return new ResponseEntity<MyErrorDetails>(myErr,HttpStatus.BAD_REQUEST);
	} 
}
