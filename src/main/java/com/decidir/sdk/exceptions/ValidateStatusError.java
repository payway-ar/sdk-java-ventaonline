package com.decidir.sdk.exceptions;

/**
 * Created by jmejia on 06/09/2018
 */
public class ValidateStatusError extends DecidirError {

	private ValidationStatus validation_errors;

	public ValidationStatus getValidation_errors() {
		return validation_errors;
	}

	public void setValidation_errors(ValidationStatus validation_errors) {
		this.validation_errors = validation_errors;
	}

	@Override
	public ValidateStatusException toException(int status, String message) {
		return new ValidateStatusException(status, message, this);
	}
}
