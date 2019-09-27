package com.decidir.sdk.dto.cybersource;

import java.io.Serializable;

/**
 * Represents a detailed error for Fraud Detection response
 *
 */
public class Csmdd implements Serializable {

	private Integer code;
	private String description;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
