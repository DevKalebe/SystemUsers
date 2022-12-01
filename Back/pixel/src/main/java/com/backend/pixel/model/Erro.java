package com.backend.pixel.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class Erro {
	private HttpStatus error;
	private String message;
	private String exception;
	
	public Erro(HttpStatus error, String message, String exception) {
		this.error = error;
		this.message = message;
		this.exception = exception;
	}
}
