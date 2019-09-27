package com.decidir.sdk.dto;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by biandra on 13/07/16.
 */
public enum CardErrorCode {

    INVALID_NUMBER("invalid_number"),
    SECURITY_CODE_ERROR("security_code_error"),
    EXPIRED_CARD("expired_card"),
    INSUFFICIENT_AMOUNT("insufficient_amount"),
    REQUEST_AUTHORIZATION_CARD("request_authorization_card"),
    CYBERSOURCE_ERROR("cybersource_error"),
    GROUP_REJECTED("group_rejected"),
    CARD_DECLINED("card_declined"),
    PROCESSING_ERROR("processing_error"),//Error entre estados
    INVALID_CARD("invalid_card"); //generic error

    private String cardErrorCodeId;

    private CardErrorCode(final String cardErrorCodeId) {
        this.cardErrorCodeId = cardErrorCodeId;
    }

    @JsonValue
    public String getCardErrorCodeId() {
        return cardErrorCodeId;
    }
}
