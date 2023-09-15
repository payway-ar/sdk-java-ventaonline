package com.decidir.sdk.exceptions;

import java.io.Serializable;
import java.util.Arrays;

public class CheckoutError implements Serializable {
    private String error_type;
    private String description;
    
    public String getError_type() {
		return error_type;
	}
	public void setError_type(String error_type) {
		this.error_type = error_type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

  
}
