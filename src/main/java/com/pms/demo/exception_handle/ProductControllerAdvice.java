package com.pms.demo.exception_handle;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler{
	
	
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleBusinessException(BusinessException BusinessException)
	{
		return new ResponseEntity<String>("Data is added Successfully", HttpStatus.CREATED);
	}
	
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleNEmptyInput(EmptyInputException EmptyInputException)
	{
		return new ResponseEntity<String>("Input field is Empty,Please look into it", HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EmptyException.class)
	public ResponseEntity<String> handleNEmptyInput(EmptyException EmptyException)
	{
		return new ResponseEntity<String>(" List is Empty", HttpStatus.NOT_FOUND);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<Object>("Please change your http method type", HttpStatus.BAD_REQUEST);
	}
  

	   
}
