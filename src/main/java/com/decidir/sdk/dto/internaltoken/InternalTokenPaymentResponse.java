package com.decidir.sdk.dto.internaltoken;

public class InternalTokenPaymentResponse {
    private Integer charge_id;
    private String amount;
    private String currency;
    private String status;
    private StatusDetailsResponse status_details;
    private String date;
    private String installments;
    private String first_installment_expiration_ate;
    private SubPaymentResponse[] sub_payments;
    private FraudDetetionResponse fraud_detection;

    public Integer getCharge_id() {
        return charge_id;
    }

    public void setCharge_id(Integer charge_id) {
        this.charge_id = charge_id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StatusDetailsResponse getStatus_details() {
        return status_details;
    }

    public void setStatus_details(StatusDetailsResponse status_details) {
        this.status_details = status_details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public String getFirst_installment_expiration_ate() {
        return first_installment_expiration_ate;
    }

    public void setFirst_installment_expiration_ate(String first_installment_expiration_ate) {
        this.first_installment_expiration_ate = first_installment_expiration_ate;
    }

    public SubPaymentResponse[] getSub_payments() {
        return sub_payments;
    }

    public void setSub_payments(SubPaymentResponse[] sub_payments) {
        this.sub_payments = sub_payments;
    }

    public FraudDetetionResponse getFraud_detection() {
        return fraud_detection;
    }

    public void setFraud_detection(FraudDetetionResponse fraud_detection) {
        this.fraud_detection = fraud_detection;
    }
}
