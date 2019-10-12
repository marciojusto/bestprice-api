package com.bestprice.api.handler;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bestprice.api.error.ResourceNotFoundDetail;
import com.bestprice.api.error.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException) {
		ResourceNotFoundDetail detail = ResourceNotFoundDetail
			.builder()
			.Timestamp(Instant.now().getEpochSecond())
			.Status(HttpStatus.NOT_FOUND.value())
			.Titulo("Resource not fund!")
			.Detalhe(rnfException.getMessage())
			.DeveloperMessage(rnfException.getClass().getName()).build();
		return new ResponseEntity<>(detail, HttpStatus.NOT_FOUND);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Error> errors = criarListaDeErros(ex.getBindingResult());
		
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Error> criarListaDeErros(BindingResult bindingResult) {
		
		List<Error> errors = new ArrayList<>();
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			Error error = new Error(messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()), fieldError.toString());
			errors.add(error);
		}
		return errors;
	}
	
	public static class Error {
		
		private String mensagemUsuario;
		private String mensagemDesenvolvedor;
		
		public Error(String mensagemUsuario, String mensagemDesenvolvedor) {
			this.mensagemUsuario = mensagemUsuario;
			this.mensagemDesenvolvedor = mensagemDesenvolvedor;
		}

		public String getMensagemUsuario() {
			return mensagemUsuario;
		}

		public String getMensagemDesenvolvedor() {
			return mensagemDesenvolvedor;
		}

	}
}
