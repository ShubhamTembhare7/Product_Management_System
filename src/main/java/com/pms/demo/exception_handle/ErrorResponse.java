package com.pms.demo.exception_handle;

public class ErrorResponse {
	  private int status;
	  private String message;
	  
	  ErrorResponse(int status,String message){
	     this.status = status;
	     this.message = message;
	  }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	}