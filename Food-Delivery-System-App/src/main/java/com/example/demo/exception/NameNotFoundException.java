package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class NameNotFoundException extends RuntimeException{

	public NameNotFoundException(String msg) {
		super(msg);
	}
}
