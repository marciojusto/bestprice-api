package com.bestprice.api.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bestprice.api.error.ResourceNotFoundDetail;
import com.bestprice.api.error.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfe) {
		ResourceNotFoundDetail detail = ResourceNotFoundDetail
			.builder()
			.Timestamp(Instant.now().getEpochSecond())
			.Status(HttpStatus.NOT_FOUND.value())
			.Titulo("Resource not fund!")
			.Detalhe(rnfe.getMessage())
			.DeveloperMessage(rnfe.getClass().getName()).build();
		return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
	}
}
