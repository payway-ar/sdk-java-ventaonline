package com.decidir.sdk.dto.payments.pci;

import java.io.Serializable;

/**
 * Abstract card data DTO with common values for PCI payments
 * @author ivalek
 *
 */
public abstract class PCICardData implements Serializable {

	private String security_code;
	private String last_four_digits;
	private String card_holder_birthday;
	private Integer card_holder_door_number;
	private CardFraudDetectionData fraud_detection;
	private String ip_address;

	public String getLast_four_digits() {return last_four_digits;}
	public void setLast_four_digits(String last_four_digits) {this.last_four_digits = last_four_digits;}
	public String getCard_holder_birthday() {return card_holder_birthday;}
	public void setCard_holder_birthday(String card_holder_birthday) {this.card_holder_birthday = card_holder_birthday;}
	public Integer getCard_holder_door_number() {return card_holder_door_number;}
	public void setCard_holder_door_number(Integer card_holder_door_number) {this.card_holder_door_number = card_holder_door_number;}
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
