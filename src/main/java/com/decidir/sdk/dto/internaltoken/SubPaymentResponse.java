package com.decidir.sdk.dto.internaltoken;

public class SubPaymentResponse {
    private String siteId;
    private Integer installments;
    private String amount;
    private String ticket;
    private String card_authorization_code;
    private Integer subPaymentId;
    private String status;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

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

    public Integer getSubPaymentId() {
        return subPaymentId;
    }

    public void setSubPaymentId(Integer subPaymentId) {
        this.subPaymentId = subPaymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
