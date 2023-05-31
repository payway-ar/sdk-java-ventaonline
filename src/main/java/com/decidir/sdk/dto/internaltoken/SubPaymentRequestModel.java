package com.decidir.sdk.dto.internaltoken;

public class SubPaymentRequestModel {
    private String siteId;
    private Integer installments;
    private String amount;
    private String ticket;
    private String card_authorization_code;
    private Integer sub_payment_id;
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

    public Integer getSub_payment_id() {
        return sub_payment_id;
    }

    public void setSub_payment_id(Integer sub_payment_id) {
        this.sub_payment_id = sub_payment_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
