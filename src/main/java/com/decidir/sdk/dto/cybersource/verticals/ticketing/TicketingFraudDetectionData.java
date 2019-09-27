package com.decidir.sdk.dto.cybersource.verticals.ticketing;

import com.decidir.sdk.dto.cybersource.FraudDetectionDataRequest;

/**
 * Ticketing specific Fraud Detection Data DTO
 */
public class TicketingFraudDetectionData extends FraudDetectionDataRequest {

	private TicketingTransactionData ticketing_transaction_data;

	public TicketingTransactionData getTicketing_transaction_data() {
		return ticketing_transaction_data;
	}

	public void setTicketing_transaction_data(TicketingTransactionData ticketing_transaction_data) {
		this.ticketing_transaction_data = ticketing_transaction_data;
	}
}
