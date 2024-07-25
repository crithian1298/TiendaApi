package com.Javacristhian.tienda_api.ExceptionMessage;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(RecursoNotFoundsException.class)
	public ResponseEntity<ErrorDetalles> handlerecursonotfoundsexception(RecursoNotFoundsException exception , WebRequest webRequest){
		ErrorDetalles errordetalles= new ErrorDetalles(new Date(),exception.getMessage(),webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetalles>(errordetalles,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TiendaApiException.class)
	public ResponseEntity<ErrorDetalles> handleTiendaApiException(TiendaApiException exception , WebRequest webRequest){
		ErrorDetalles errordetalles= new ErrorDetalles(new Date(),exception.getMessage(),webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetalles>(errordetalles,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetalles> handleGlobalException(Exception exception , WebRequest webRequest){
		ErrorDetalles errordetalles= new ErrorDetalles(new Date(),exception.getMessage(),webRequest.getDescription(false));
		
		return new ResponseEntity<ErrorDetalles>(errordetalles,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String ,String > errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String fieldName=((FieldError)error).getField();
			String mensage=error.getDefaultMessage();
			errors.put(fieldName,mensage);
		});
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	

}
