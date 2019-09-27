package com.decidir.sdk.dto.payments.pci;

import java.io.Serializable;

/**
 * Abstract card data DTO with common values for PCI payments
 * @author ivalek
 *
 */
public abstract class PCICardData implements Serializable {

	private String security_code;
	private CardFraudDetectionData fraud_detection;
	private String ip_address;
	
	public String getSecurity_code() {
		return security_code;
	}
	public void setSecurity_code(String security_code) {
		this.security_code = security_code;
	}
	public CardFraudDetectionData getFraud_detection() {
		return fraud_detection;
	}
	public void setFraud_detection(CardFraudDetectionData fraud_detection) {
		this.fraud_detection = fraud_detection;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	
}
