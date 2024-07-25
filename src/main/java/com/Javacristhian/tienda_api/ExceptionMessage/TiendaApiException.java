package com.Javacristhian.tienda_api.ExceptionMessage;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class TiendaApiException extends RuntimeException{
	private static final long serialVersionUID = 1L;
    private HttpStatus status;
    private String mensage;

}
