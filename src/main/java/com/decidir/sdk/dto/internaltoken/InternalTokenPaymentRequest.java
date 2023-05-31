package com.decidir.sdk.dto.internaltoken;

public class InternalTokenPaymentRequest {
    private String merchant_id;
    private TransactionDataRequestModel transaction_data;
    private CustomerDataRequestModel customer_data;

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public TransactionDataRequestModel getTransaction_data() {
        return transaction_data;
    }

    public void setTransaction_data(TransactionDataRequestModel transaction_data) {
        this.transaction_data = transaction_data;
    }

    public CustomerDataRequestModel getCustomer_data() {
        return customer_data;
    }

    public void setCustomer_data(CustomerDataRequestModel customer_data) {
        this.customer_data = customer_data;
    }
}
