package com.decidir.sdk.dto.cybersource.verticals.tpretails;

import com.decidir.sdk.dto.cybersource.FraudDetectionDataRequest;

/**
 * RetailTP specific Fraud Detection Data DTO
 */
public class RetailTPFraudDetectionData extends FraudDetectionDataRequest {

    private RetailTPTransactionData retailtp_transaction_data;

    public RetailTPTransactionData getRetailtp_transaction_data() {
        return retailtp_transaction_data;
    }

    public void setRetailtp_transaction_data(RetailTPTransactionData retailtp_transaction_data) {
        this.retailtp_transaction_data = retailtp_transaction_data;
    }

}
