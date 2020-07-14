package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomisedException  extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {RuntimeException.class })
	ResponseEntity<Object> badRequestException(BadRequestException ex, WebRequest request){
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Request is not proper!", details);
		 return new ResponseEntity(error,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value=NameNotFoundException.class)
	ResponseEntity<Object> NotFoundException(NameNotFoundException ex, WebRequest request){
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Name is not found!", details);
		 return new ResponseEntity(error,HttpStatus.NOT_FOUND);
	}
}

