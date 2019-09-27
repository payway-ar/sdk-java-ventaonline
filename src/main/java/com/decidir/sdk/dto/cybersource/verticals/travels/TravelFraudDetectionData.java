package com.decidir.sdk.dto.cybersource.verticals.travels;

import com.decidir.sdk.dto.cybersource.FraudDetectionDataRequest;

/**
 * Travel specific Fraud Detection Data DTO
 */
public class TravelFraudDetectionData extends FraudDetectionDataRequest {

	private TravelTransactionData travel_transaction_data;

	public TravelTransactionData getTravel_transaction_data() {
		return travel_transaction_data;
	}

	public void setTravel_transaction_data(TravelTransactionData travel_transaction_data) {
		this.travel_transaction_data = travel_transaction_data;
	}
}
