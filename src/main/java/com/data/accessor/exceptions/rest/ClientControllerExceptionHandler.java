package com.data.accessor.exceptions.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.data.accessor.exceptions.ErrorResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebMvc
@RestControllerAdvice
public class ClientControllerExceptionHandler {
	@ExceptionHandler( value = {RuntimeException.class})
	public ResponseEntity<?> handleError(RuntimeException ex) {
		log.error("Client Controller failed {}" , ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Integer.toString(HttpStatus.BAD_REQUEST.value()), ex.getLocalizedMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler( value = {MethodArgumentNotValidException.class})
	public ResponseEntity<?> handleError(MethodArgumentNotValidException ex) {
		log.error("Client Controller failed {}" , ex.getMessage());
		ErrorResponse errorResponse = new ErrorResponse(Integer.toString(HttpStatus.BAD_REQUEST.value()), ex.getLocalizedMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}
