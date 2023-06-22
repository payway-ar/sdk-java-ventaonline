package com.decidir.sdk.exceptions;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class CheckoutValidationError implements Serializable {
    private String error_type;
    private List<ValidationError> validation_errors;
    
    public String getError_type() {
		return error_type;
	}
	public void setError_type(String error_type) {
		this.error_type = error_type;
	}
	public List<ValidationError> getValidation_errors() {
		return validation_errors;
	}
	public void setValidation_errors(List<ValidationError> validation_errors) {
		this.validation_errors = validation_errors;
	}
	

  
}
