package com.decidir.sdk.dto.checkout.history;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ButtonDto {

    @JsonProperty("site_id")
    private String siteId;

    @JsonProperty("operation_id")
    private String operationId;

    @JsonProperty("payment_method_id")
    private Long paymentMethodId;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("installments")
    private Integer installments;

    @JsonProperty("link_hash")
    private String linkHash;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("link_expires_at")
    private String linkExpiresAt;

    @JsonProperty("status")
    private String status;

    @JsonProperty("description")
    private String description;

    @JsonProperty("link_updated_at")
    private String linkUpdatedAt;

    @JsonProperty("establishment_number")
    private Long establishmentNumber;

    @JsonProperty("send_to_cs")
    private Integer sendToCs;

    @JsonProperty("source_app")
    private String sourceApp;

    @JsonProperty("platform")
    private String originPlatform;

    @JsonProperty("holder_name")
    private String holderName;

    @JsonProperty("auth_code")
    private String authCode;

    @JsonProperty("card_number")
    private String cardNumber;

    @JsonProperty("cuit")
    private String cuit;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("charge_id")
    private String chargeId;

    @JsonProperty("site_transaction_id")
    private String siteTransactionId;

    @JsonProperty("installment_type")
    private String installmentType;

    @JsonProperty("url")
    private String url;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    public String getLinkHash() {
        return linkHash;
    }

    public void setLinkHash(String linkHash) {
        this.linkHash = linkHash;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLinkExpiresAt() {
        return linkExpiresAt;
    }

    public void setLinkExpiresAt(String linkExpiresAt) {
        this.linkExpiresAt = linkExpiresAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkUpdatedAt() {
        return linkUpdatedAt;
    }

    public void setLinkUpdatedAt(String linkUpdatedAt) {
        this.linkUpdatedAt = linkUpdatedAt;
    }

    public Long getEstablishmentNumber() {
        return establishmentNumber;
    }

    public void setEstablishmentNumber(Long establishmentNumber) {
        this.establishmentNumber = establishmentNumber;
    }

    public Integer getSendToCs() {
        return sendToCs;
    }

    public void setSendToCs(Integer sendToCs) {
        this.sendToCs = sendToCs;
    }

    public String getSourceApp() {
        return sourceApp;
    }

    public void setSourceApp(String sourceApp) {
        this.sourceApp = sourceApp;
    }

    public String getOriginPlatform() {
        return originPlatform;
    }

    public void setOriginPlatform(String originPlatform) {
        this.originPlatform = originPlatform;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getSiteTransactionId() {
        return siteTransactionId;
    }

    public void setSiteTransactionId(String siteTransactionId) {
        this.siteTransactionId = siteTransactionId;
    }

    public String getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(String installmentType) {
        this.installmentType = installmentType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
