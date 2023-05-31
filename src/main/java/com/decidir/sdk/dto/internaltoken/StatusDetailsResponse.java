package com.decidir.sdk.dto.internaltoken;

public class StatusDetailsResponse {
    private String ticket;
    private String card_authorization_code;
    private String address_validation_code;
    private ErrorPaymentResponse error;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getCard_authorization_code() {
        return card_authorization_code;
    }

    public void setCard_authorization_code(String card_authorization_code) {
        this.card_authorization_code = card_authorization_code;
    }

    public String getAddress_validation_code() {
        return address_validation_code;
    }

    public void setAddress_validation_code(String address_validation_code) {
        this.address_validation_code = address_validation_code;
    }

    public ErrorPaymentResponse getError() {
        return error;
    }

    public void setError(ErrorPaymentResponse error) {
        this.error = error;
    }
}
