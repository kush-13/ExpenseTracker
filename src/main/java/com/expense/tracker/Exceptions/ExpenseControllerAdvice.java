package com.expense.tracker.Exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.expense.tracker.DTO.ErrorMessage;

@RestControllerAdvice
public class ExpenseControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleValidationErrors(MethodArgumentNotValidException ex) {
		System.out.println(ex);
		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> {
			return x.getField() + ": " + x.getDefaultMessage();
		}).collect(Collectors.toList());
		
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), errors.toString()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<ErrorMessage> handleNoSuchUserException(NoSuchUserException ex) {
		System.out.println(ex);
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleErrors(Exception ex) {
		System.out.println(ex);
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
				HttpStatus.BAD_REQUEST);
	}
}
