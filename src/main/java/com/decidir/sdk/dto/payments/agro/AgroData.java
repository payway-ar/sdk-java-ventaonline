package com.decidir.sdk.dto.payments.agro;

public class AgroData {
    private String token_type;
    private int days_agreement;
    private String token;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getDays_agreement() {
        return days_agreement;
    }

    public void setDays_agreement(int days_agreement) {
        this.days_agreement = days_agreement;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
