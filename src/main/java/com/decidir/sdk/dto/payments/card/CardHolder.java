package com.decidir.sdk.dto.payments.card;

import com.decidir.sdk.dto.payments.Identification;

public class CardHolder {

	private Identification identification;

	private String name;

	private String birthday;

	private Integer nro_puerta;

	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getNro_puerta() {
		return nro_puerta;
	}

	public void setNro_puerta(Integer nro_puerta) {
		this.nro_puerta = nro_puerta;
	}
}
