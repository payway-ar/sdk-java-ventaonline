package com.decidir.sdk.dto.internaltoken;

import java.io.Serializable;

public class InternalTokenRequest implements Serializable {
    private CardDataRequestModel card_data;
    private String establishment_number;

    public CardDataRequestModel getCard_data() {
        return card_data;
    }

    public void setCard_data(CardDataRequestModel card_data) {
        this.card_data = card_data;
    }

    public String getEstablishment_number() {
        return establishment_number;
    }

    public void setEstablishment_number(String establishment_number) {
        this.establishment_number = establishment_number;
    }
}
