package com.decidir.sdk.dto.payments;

import java.io.Serializable;

/**
 * Cardholder identification DTO
 * @author ivalek
 *
 */
public class Identification implements Serializable {

	private IdentificationType type;
	private String number;
	
	public IdentificationType getType() {
		return type;
	}
	public void setType(IdentificationType type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
