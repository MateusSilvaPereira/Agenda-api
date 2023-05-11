package com.msp.agenda.services.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DataBindingViolationException extends DataIntegrityViolationException{
	
	private static final long serialVersionUID = 1L;

	public DataBindingViolationException(String message) {
		super(message);
	}
}
