package com.decidir.sdk.dto.internaltoken;

public class TransactionDataRequestModel {
    private String merchant_transaction_id;
    private String original_transaction_id;
    private String payment_method_id;
    private String amount;
    private String currency;
    private String installments;
    private String payment_type;
    private SubPaymentRequestModel[] sub_payments;
    private String description;
    private InvoiceRequestModel invoice;
    private Boolean store_credential;

    public String getMerchant_transaction_id() {
        return merchant_transaction_id;
    }

    public void setMerchant_transaction_id(String merchant_transaction_id) {
        this.merchant_transaction_id = merchant_transaction_id;
    }

    public String getOriginal_transaction_id() {
        return original_transaction_id;
    }

    public void setOriginal_transaction_id(String original_transaction_id) {
        this.original_transaction_id = original_transaction_id;
    }

    public String getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(String payment_method_id) {
        this.payment_method_id = payment_method_id;
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

    public String getInstallments() {
        return installments;
    }

    public void setInstallments(String installments) {
        this.installments = installments;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public SubPaymentRequestModel[] getSub_payments() {
        return sub_payments;
    }

    public void setSub_payments(SubPaymentRequestModel[] sub_payments) {
        this.sub_payments = sub_payments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InvoiceRequestModel getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceRequestModel invoice) {
        this.invoice = invoice;
    }

    public Boolean getStore_credential() {
        return store_credential;
    }

    public void setStore_credential(Boolean store_credential) {
        this.store_credential = store_credential;
    }
}
