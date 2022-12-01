package com.backend.pixel.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class Success {
	
	private HttpStatus error;
	private String message;
	
	public Success(HttpStatus error, String message) {
		this.error = error;
		this.message = message;
	}
}
