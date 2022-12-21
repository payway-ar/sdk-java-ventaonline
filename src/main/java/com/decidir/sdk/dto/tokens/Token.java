package com.decidir.sdk.dto.tokens;

import java.io.Serializable;

import com.decidir.sdk.dto.payments.Identification;

public class Token implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String card_number;
	private String card_expiration_month;
	private String card_expiration_year;
	private String security_code;
	private String card_holder_name;
	private Identification card_holder_identification;
	private int card_holder_door_number;
	private String card_holder_birthday;
	private FraudDetectionModel fraud_detection;
	private String ip_address;
	
	public String getCard_number() {
		return card_number;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	
	public String getCard_expiration_month() {
		return card_expiration_month;
	}
	public void setCard_expiration_month(String card_expiration_month) {
		this.card_expiration_month = card_expiration_month;
	}
	
	public String getCard_expiration_year() {
		return card_expiration_year;
	}
	public void setCard_expiration_year(String card_expiration_year) {
		this.card_expiration_year = card_expiration_year;
	}
	
	public String getSecurity_code() {
		return security_code;
	}
	public void setSecurity_code(String security_code) {
		this.security_code = security_code;
	}
	
	public String getCard_holder_name() {
		return card_holder_name;
	}
	public void setCard_holder_name(String card_holder_name) {
		this.card_holder_name = card_holder_name;
	}
	
	public Identification getCard_holder_identification() {
		return card_holder_identification;
	}
	public void setCard_holder_identification(Identification card_holder_identification) {
		this.card_holder_identification = card_holder_identification;
	}
	public int getCard_holder_door_number() {
		return card_holder_door_number;
	}
	public void setCard_holder_door_number(int card_holder_door_number) {
		this.card_holder_door_number = card_holder_door_number;
	}
	public String getCard_holder_birthday() {
		return card_holder_birthday;
	}
	public void setCard_holder_birthday(String card_holder_birthday) {
		this.card_holder_birthday = card_holder_birthday;
	}
	public FraudDetectionModel getFraud_detection() {
		return fraud_detection;
	}
	public void setFraud_detection(FraudDetectionModel fraud_detection) {
		this.fraud_detection = fraud_detection;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	
	

}
