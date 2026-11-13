package com.decidir.sdk.dto.checkout.transactionHistory;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TransactionDto {

    private String transactionId;
    private String statusId;
    private String createdAt;
    private String statusDescription;
    private String holderName;
    private String cardNumber;
    private String paymentMethodId;
    private String rejectionDescription;
    private String tid;

    public TransactionDto() {}

    public TransactionDto(String transactionId, String statusId, String createdAt,
                          String statusDescription, String holderName, String cardNumber,
                          String paymentMethodId, String rejectionDescription, String tid) {
        this.transactionId = transactionId;
        this.statusId = statusId;
        this.createdAt = createdAt;
        this.statusDescription = statusDescription;
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.paymentMethodId = paymentMethodId;
        this.rejectionDescription = rejectionDescription;
        this.tid = tid;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getRejectionDescription() {
        return rejectionDescription;
    }

    public void setRejectionDescription(String rejectionDescription) {
        this.rejectionDescription = rejectionDescription;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    // --- TO_STRING ---

    @Override
    public String toString() {
        return "TransactionDto{" +
                "transactionId='" + transactionId + '\'' +
                ", statusId='" + statusId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", statusDescription='" + statusDescription + '\'' +
                ", holderName='" + holderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", paymentMethodId='" + paymentMethodId + '\'' +
                ", rejectionDescription='" + rejectionDescription + '\'' +
                ", tid='" + tid + '\'' +
                '}';
    }
}