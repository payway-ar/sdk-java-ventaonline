package com.decidir.sdk.dto.tokens;

import com.decidir.sdk.dto.cybersource.FraudDetectionData;

public class PaymentTokenCS extends PaymentToken {
	
	private FraudDetectionData fraud_detection;
	private String ip_address;
	
	public FraudDetectionData getFraud_detection() {
		return fraud_detection;
	}
	public void setFraud_detection(FraudDetectionData fraud_detection) {
		this.fraud_detection = fraud_detection;
	}
	
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	
	
}
