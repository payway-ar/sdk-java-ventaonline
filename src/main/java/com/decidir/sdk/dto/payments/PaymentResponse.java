package com.decidir.sdk.dto.payments;

import java.io.Serializable;

import com.decidir.sdk.dto.Status;
import com.decidir.sdk.dto.StatusDetails;
import com.decidir.sdk.dto.payments.card.CardData;
import com.decidir.sdk.payments.Payment;

/**
 * DTO Payment response used to communicate with Decidir's Payment Service 
 */
public class PaymentResponse extends Payment implements Serializable {

	private String token;
	private String date;
	private String date_created;
	private String date_approved;
	private String date_last_updated;
	private Status status;
	private StatusDetails status_details;
	private ConfirmedPaymentData confirmed;
	private String pan;
	private String customer_token;
	private CardData card_data;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public String getDate_approved() {
		return date_approved;
	}

	public void setDate_approved(String date_approved) {
		this.date_approved = date_approved;
	}

	public String getDate_last_updated() {
		return date_last_updated;
	}

	public void setDate_last_updated(String date_last_updated) {
		this.date_last_updated = date_last_updated;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public StatusDetails getStatus_details() {
		return status_details;
	}

	public void setStatus_details(StatusDetails status_details) {
		this.status_details = status_details;
	}

	public ConfirmedPaymentData getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(ConfirmedPaymentData confirmed) {
		this.confirmed = confirmed;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getCustomer_token() {
		return customer_token;
	}

	public void setCustomer_token(String customer_token) {
		this.customer_token = customer_token;
	}

	public CardData getCard_data() {
		return card_data;
	}

	public void setCard_data(CardData card_data) {
		this.card_data = card_data;
	}

}
