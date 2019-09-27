package com.decidir.sdk.dto.cybersource.verticals.digitalgoods;

import com.decidir.sdk.dto.cybersource.FraudDetectionDataRequest;

/**
 * Ticketing specific Fraud Detection Data DTO
 */
public class DigitalGoodsFraudDetectionData extends FraudDetectionDataRequest {

	private DigitalGoodsTransactionData digital_goods_transaction_data;


	public DigitalGoodsTransactionData getDigital_goods_transaction_data() {
		return digital_goods_transaction_data;
	}

	public void setDigital_goods_transaction_data(DigitalGoodsTransactionData digital_goods_transaction_data) {
		this.digital_goods_transaction_data = digital_goods_transaction_data;
	}
}
