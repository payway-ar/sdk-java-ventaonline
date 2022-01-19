package com.decidir.sdk.dto.tokens;

import com.decidir.sdk.dto.cybersource.FraudDetectionData;

public class TokenRequest extends Token {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String device_unique_identifier;
	private FraudDetectionData fraud_detection;
	private String ip_address;
	
	/**
	 * @return the device_unique_identifier
	 */
	public String getDevice_unique_identifier() {
		return device_unique_identifier;
	}
	/**
	 * @param device_unique_identifier the device_unique_identifier to set
	 */
	public void setDevice_unique_identifier(String device_unique_identifier) {
		this.device_unique_identifier = device_unique_identifier;
	}
	/**
	 * @return the fraud_detection
	 */
	public FraudDetectionData getFraud_detection() {
		return fraud_detection;
	}
	/**
	 * @param fraud_detection the fraud_detection to set
	 */
	public void setFraud_detection(FraudDetectionData fraud_detection) {
		this.fraud_detection = fraud_detection;
	}
	/**
	 * @return the ip_address
	 */
	public String getIp_address() {
		return ip_address;
	}
	/**
	 * @param ip_address the ip_address to set
	 */
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
}
