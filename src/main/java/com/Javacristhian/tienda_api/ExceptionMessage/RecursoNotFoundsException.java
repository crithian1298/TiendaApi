package com.Javacristhian.tienda_api.ExceptionMessage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class RecursoNotFoundsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String resourcename;
	private String fieldName;
	private Long   fielsValue;
	public RecursoNotFoundsException(String resourcename, String fieldName, Long fielsValue) {
		super(String .format("%s no se encontro el recurso con el valor %s:'%s' ", resourcename,fieldName,fielsValue ));
		this.resourcename = resourcename;
		this.fieldName = fieldName;
		this.fielsValue = fielsValue;
	}
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public Long getFielsValue() {
		return fielsValue;
	}
	public void setFielsValue(Long fielsValue) {
		this.fielsValue = fielsValue;
	}

	
}
