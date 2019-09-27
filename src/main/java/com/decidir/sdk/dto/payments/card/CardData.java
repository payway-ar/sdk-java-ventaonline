package com.decidir.sdk.dto.payments.card;

public class CardData {

	private String card_number;

	private CardHolder card_holder;

	public CardData(String card_number) {
	}

	public CardData() {
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}

	public CardHolder getCard_holder() {
		return card_holder;
	}

	public void setCard_holder(CardHolder card_holder) {
		this.card_holder = card_holder;
	}
}
