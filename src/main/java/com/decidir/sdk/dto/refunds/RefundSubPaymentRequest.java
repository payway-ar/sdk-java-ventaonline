package com.decidir.sdk.dto.refunds;

import java.util.List;

public class RefundSubPaymentRequest {
	private List<RefundSubPayment> sub_payments;

	public List<RefundSubPayment> getSub_payments() {
		return sub_payments;
	}

	public void setSub_payments(List<RefundSubPayment> sub_payments) {
		this.sub_payments = sub_payments;
	}
	
	

}
