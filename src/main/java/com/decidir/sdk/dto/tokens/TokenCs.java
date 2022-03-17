package com.decidir.sdk.dto.tokens;

import com.decidir.sdk.dto.cybersource.FraudDetectionData;

public class TokenCs extends Token {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
//	private String device_unique_identifier;
	private FraudDetectionModel fraud_detection;
//	private String ip_address;

	public FraudDetectionModel getFraud_detection() {
		return fraud_detection;
	}

	public void setFraud_detection(FraudDetectionModel fraud_detection) {
		this.fraud_detection = fraud_detection;
	}
	
	
	
//	public String getDevice_unique_identifier() {
//		return device_unique_identifier;
//	}
//	public void setDevice_unique_identifier(String device_unique_identifier) {
//		this.device_unique_identifier = device_unique_identifier;
//	}
	
//	public FraudDetectionData getFraud_detection() {
//		return fraud_detection;
//	}
//	public void setFraud_detection(FraudDetectionData fraud_detection) {
//		this.fraud_detection = fraud_detection;
//	}
//	public String getIp_address() {
//		return ip_address;
//	}
//	public void setIp_address(String ip_address) {
//		this.ip_address = ip_address;
//	}

}
