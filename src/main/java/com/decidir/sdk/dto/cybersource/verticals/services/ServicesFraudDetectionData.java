package com.decidir.sdk.dto.cybersource.verticals.services;

import com.decidir.sdk.dto.cybersource.FraudDetectionDataRequest;

/**
 * Services specific Fraud Detection Data DTO
 */
public class ServicesFraudDetectionData extends FraudDetectionDataRequest {

    private ServicesTransactionData services_transaction_data;

    public ServicesTransactionData getServices_transaction_data() {
        return services_transaction_data;
    }

    public void setServices_transaction_data(ServicesTransactionData services_transaction_data) {
        this.services_transaction_data = services_transaction_data;
    }

}
