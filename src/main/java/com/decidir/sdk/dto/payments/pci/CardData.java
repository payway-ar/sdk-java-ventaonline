package com.decidir.sdk.dto.payments.pci;

import com.decidir.sdk.dto.payments.Identification;

/**
 * Specific CardData DTO required for PCI payments
*/
public class CardData extends PCICardData {

	private String card_number;
	private String card_expiration_month;
	private String card_expiration_year;
	private String card_holder_name;
	private Identification card_holder_identification;
	private CardTrackInfo card_track_info;
	
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
	public CardTrackInfo getCard_track_info() {
		return card_track_info;
	}
	public void setCard_track_info(CardTrackInfo card_track_info) {
		this.card_track_info = card_track_info;
	}
}
