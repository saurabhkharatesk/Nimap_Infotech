package edu.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.main.exception.CategoryNotFoundException;

@ControllerAdvice
public class CategoryExceptionController {

	@ExceptionHandler(value =CategoryNotFoundException.class)
	public ResponseEntity<Object> exception (CategoryNotFoundException exception)
	{
		return new ResponseEntity<Object>("Category not found",HttpStatus.NOT_FOUND);
		
	}
}
