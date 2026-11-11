package com.decidir.sdk.dto.checkout.transactionHistory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionHistoryRequest {

    @JsonProperty("charge_id")
    private String chargeId;


    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }
}