package com.decidir.sdk.dto.payments;

import java.io.Serializable;

public class Aggregator implements Serializable {

	private String indicator;
	private String identification_number;
	private String bill_to_pay;
	private String bill_to_refund;
	private String merchant_name;
	private String street;
	private String number;
	private String postal_code;
	private String category;
	private String channel;
	private String geographic_code;
	private String city;
	private String merchant_id;
	private String province;
	private String country;
	private String merchant_email;
	private String merchant_phone;
	private SubAgrupator sub_agrupator;

	public String getIndicator() {
		return indicator;
	}

	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}

	public String getIdentification_number() {
		return identification_number;
	}

	public void setIdentification_number(String identification_number) {
		this.identification_number = identification_number;
	}

	public String getBill_to_pay() {
		return bill_to_pay;
	}

	public void setBill_to_pay(String bill_to_pay) {
		this.bill_to_pay = bill_to_pay;
	}

	public String getBill_to_refund() {
		return bill_to_refund;
	}

	public void setBill_to_refund(String bill_to_refund) {
		this.bill_to_refund = bill_to_refund;
	}

	public String getMerchant_name() {
		return merchant_name;
	}

	public void setMerchant_name(String merchant_name) {
		this.merchant_name = merchant_name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getGeographic_code() {
		return geographic_code;
	}

	public void setGeographic_code(String geographic_code) {
		this.geographic_code = geographic_code;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMerchant_email() {
		return merchant_email;
	}

	public void setMerchant_email(String merchant_email) {
		this.merchant_email = merchant_email;
	}

	public String getMerchant_phone() {
		return merchant_phone;
	}

	public void setMerchant_phone(String merchant_phone) {
		this.merchant_phone = merchant_phone;
	}

	public SubAgrupator getSub_agrupator() {
		return sub_agrupator;
	}

	public void setSub_agrupator(SubAgrupator sub_agrupator) {
		this.sub_agrupator = sub_agrupator;
	}
}
