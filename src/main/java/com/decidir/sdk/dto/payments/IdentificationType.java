package com.decidir.sdk.dto.payments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Valid indentification types for cardholder identification data
 * @author ivalek
 *
 */
public enum IdentificationType {

	NO_DOC(0, "no doc"),
	DNI(1,"dni");
	
	private int id;
	private String value;
	
	private IdentificationType(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
	@Override
	@JsonValue
	public String toString() {
		return this.value;
	}
	@JsonCreator
	public static IdentificationType fromId(int id) {
		for (IdentificationType element : IdentificationType.values()) {
			if(element.id == id) return element; 
		}
		return IdentificationType.NO_DOC;
	}

	@JsonCreator
	public static IdentificationType fromId(String id) {
		for (IdentificationType element : IdentificationType.values()) {
			if(element.value.equals(id)) return element;
		}
		return IdentificationType.NO_DOC;
	}
}
