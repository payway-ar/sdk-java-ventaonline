package com.decidir.sdk.dto.checkout;

public class CheckoutResponse {
    private String operation_id;
    private String payment_link;


	public String getPayment_link() {
		return payment_link;
	}

	public void setPayment_link(String payment_link) {
		this.payment_link = payment_link;
	}

	public String getOperation_id() {
		return operation_id;
	}

	public void setOperation_id(String operation_id) {
		this.operation_id = operation_id;
	}

}
