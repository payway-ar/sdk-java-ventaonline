package com.decidir.sdk.dto.forms;

import com.decidir.sdk.dto.payments.Currency;
import com.decidir.sdk.dto.payments.PaymentType;
import com.decidir.sdk.dto.payments.SubPayment;

import java.io.Serializable;
import java.util.List;

/**
 * Created by biandra on 19/06/17.
 */
public class PaymentForm implements Serializable {

    private Currency currency;
    private Long amount;
    private Integer installments;
    private Integer payment_method_id;
    private PaymentType payment_type; // single / distributed
    private List<SubPayment> sub_payments;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public Integer getPayment_method_id() {
		return payment_method_id;
	}

	public void setPayment_method_id(Integer payment_method_id) {
		this.payment_method_id = payment_method_id;
	}

	public PaymentType getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(PaymentType payment_type) {
        this.payment_type = payment_type;
    }

    public List<SubPayment> getSub_payments() {
        return sub_payments;
    }

    public void setSub_payments(List<SubPayment> sub_payments) {
        this.sub_payments = sub_payments;
    }
}
