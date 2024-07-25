package com.Javacristhian.tienda_api.ExceptionMessage;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetalles {
	private Date tiempos;
	private String mensage;
	private String detalles;
}
