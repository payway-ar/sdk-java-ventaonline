package com.decidir.sdk.dto.cybersource;

import java.io.Serializable;

public class CopyPasteCardData implements Serializable {

	private Boolean card_number;
	private Boolean security_code;

	public Boolean getCard_number() {
		return card_number;
	}

	public void setCard_number(Boolean card_number) {
		this.card_number = card_number;
	}

	public Boolean getSecurity_code() {
		return security_code;
	}

	public void setSecurity_code(Boolean security_code) {
		this.security_code = security_code;
	}
}
