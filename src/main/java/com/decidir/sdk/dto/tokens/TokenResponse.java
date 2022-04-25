package com.decidir.sdk.dto.tokens;

import java.io.Serializable;

import com.decidir.sdk.dto.payments.card.CardHolder;

public class TokenResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String status;
	private Integer card_number_length;
	private String date_created;
	private String bin;
	private String last_four_digits;
	private Integer security_code_length;
	private Integer expiration_month;
	private Integer expiration_year;
	private String date_due;
	private CardHolder cardholder;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the card_number_length
	 */
	public Integer getCard_number_length() {
		return card_number_length;
	}
	/**
	 * @param card_number_length the card_number_length to set
	 */
	public void setCard_number_length(Integer card_number_length) {
		this.card_number_length = card_number_length;
	}
	/**
	 * @return the date_created
	 */
	public String getDate_created() {
		return date_created;
	}
	/**
	 * @param date_created the date_created to set
	 */
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}
	/**
	 * @return the bin
	 */
	public String getBin() {
		return bin;
	}
	/**
	 * @param bin the bin to set
	 */
	public void setBin(String bin) {
		this.bin = bin;
	}
	/**
	 * @return the last_four_digits
	 */
	public String getLast_four_digits() {
		return last_four_digits;
	}
	/**
	 * @param last_four_digits the last_four_digits to set
	 */
	public void setLast_four_digits(String last_four_digits) {
		this.last_four_digits = last_four_digits;
	}
	/**
	 * @return the security_code_length
	 */
	public Integer getSecurity_code_length() {
		return security_code_length;
	}
	/**
	 * @param security_code_length the security_code_length to set
	 */
	public void setSecurity_code_length(Integer security_code_length) {
		this.security_code_length = security_code_length;
	}
	/**
	 * @return the expiration_month
	 */
	public Integer getExpiration_month() {
		return expiration_month;
	}
	/**
	 * @param expiration_month the expiration_month to set
	 */
	public void setExpiration_month(Integer expiration_month) {
		this.expiration_month = expiration_month;
	}
	/**
	 * @return the expiration_year
	 */
	public Integer getExpiration_year() {
		return expiration_year;
	}
	/**
	 * @param expiration_year the expiration_year to set
	 */
	public void setExpiration_year(Integer expiration_year) {
		this.expiration_year = expiration_year;
	}
	/**
	 * @return the date_due
	 */
	public String getDate_due() {
		return date_due;
	}
	/**
	 * @param date_due the date_due to set
	 */
	public void setDate_due(String date_due) {
		this.date_due = date_due;
	}
	/**
	 * @return the cardholder
	 */
	public CardHolder getCardholder() {
		return cardholder;
	}
	/**
	 * @param cardholder the cardholder to set
	 */
	public void setCardholder(CardHolder cardholder) {
		this.cardholder = cardholder;
	}
}
