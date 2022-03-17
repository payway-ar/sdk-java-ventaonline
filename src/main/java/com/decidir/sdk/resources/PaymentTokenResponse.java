package com.decidir.sdk.resources;

import com.decidir.sdk.dto.Status;
import com.decidir.sdk.dto.payments.card.CardHolder;

public class PaymentTokenResponse {
	
	private String id;
	private Status status;
	private Integer card_number_length;
	private String date_created;
	private String bin;
	private String last_four_digits;
	private Integer security_code_length;
	private Integer expiration_month;
	private Integer expiration_year;
	private String date_due;
	private CardHolder card_holder;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Integer getCard_number_length() {
		return card_number_length;
	}
	public void setCard_number_length(Integer card_number_length) {
		this.card_number_length = card_number_length;
	}
	public String getDate_created() {
		return date_created;
	}
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	public String getBin() {
		return bin;
	}
	public void setBin(String bin) {
		this.bin = bin;
	}
	public String getLast_four_digits() {
		return last_four_digits;
	}
	public void setLast_four_digits(String last_four_digits) {
		this.last_four_digits = last_four_digits;
	}
	public Integer getSecurity_code_length() {
		return security_code_length;
	}
	public void setSecurity_code_length(Integer security_code_length) {
		this.security_code_length = security_code_length;
	}
	public Integer getExpiration_month() {
		return expiration_month;
	}
	public void setExpiration_month(Integer expiration_month) {
		this.expiration_month = expiration_month;
	}
	public Integer getExpiration_year() {
		return expiration_year;
	}
	public void setExpiration_year(Integer expiration_year) {
		this.expiration_year = expiration_year;
	}
	public String getDate_due() {
		return date_due;
	}
	public void setDate_due(String date_due) {
		this.date_due = date_due;
	}
	public CardHolder getCard_holder() {
		return card_holder;
	}
	public void setCard_holder(CardHolder card_holder) {
		this.card_holder = card_holder;
	}
	
	
}
