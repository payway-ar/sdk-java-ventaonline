package com.decidir.sdk.dto.cybersource.verticals.retails;

import com.decidir.sdk.dto.cybersource.FraudDetectionDataRequest;

/**
 * Retail specific Fraud Detection Data DTO
 */
public class RetailFraudDetectionData extends FraudDetectionDataRequest {

	private RetailTransactionData retail_transaction_data;

	public RetailTransactionData getRetail_transaction_data() {
		return retail_transaction_data;
	}

	public void setRetail_transaction_data(RetailTransactionData retail_transaction_data) {
		this.retail_transaction_data = retail_transaction_data;
	}

}
