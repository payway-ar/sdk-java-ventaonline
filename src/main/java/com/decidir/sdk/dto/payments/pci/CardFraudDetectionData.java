package com.decidir.sdk.dto.payments.pci;

import java.io.Serializable;

/**
 * Fraud detection card data DTO for PCI pauments
 * @author ivalek
 *
 */
public class CardFraudDetectionData implements Serializable {

	private String device_unique_identifier;

	public String getDevice_unique_identifier() {
		return device_unique_identifier;
	}

	public void setDevice_unique_identifier(String device_unique_identifier) {
		this.device_unique_identifier = device_unique_identifier;
	}
}
