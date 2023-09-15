package com.decidir.sdk.dto.internaltoken;

public class CardDataRequestModel {
    private String card_number;
    private String expiration_date;
    private String card_holder;
    private String security_code;
    private String account_number;
    private String email_holder;

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getCard_holder() {
        return card_holder;
    }

    public void setCard_holder(String card_holder) {
        this.card_holder = card_holder;
    }

    public String getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(String security_code) {
        this.security_code = security_code;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getEmail_holder() {
        return email_holder;
    }

    public void setEmail_holder(String email_holder) {
        this.email_holder = email_holder;
    }
}
