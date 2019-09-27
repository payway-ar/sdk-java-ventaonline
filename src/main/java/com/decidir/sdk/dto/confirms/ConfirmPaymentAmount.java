package com.decidir.sdk.dto.confirms;

import java.io.Serializable;

/**
 * Represents the payment confirmation body request
 * Could be empty 
 */
public class ConfirmPaymentAmount implements Serializable {

    private Long amount;

    public ConfirmPaymentAmount() {
		this(null);
	}
    
    public ConfirmPaymentAmount(Long amount) {
    	this.amount = amount;
    }
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
