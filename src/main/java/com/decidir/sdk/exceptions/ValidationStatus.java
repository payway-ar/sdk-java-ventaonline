package com.decidir.sdk.exceptions;

import java.io.Serializable;

/**
 * Created by jmejia on 06/09/2018
 */
public class ValidationStatus implements Serializable {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
