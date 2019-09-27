package com.decidir.sdk.payments;

import com.decidir.sdk.dto.payments.Currency;
import com.decidir.sdk.dto.payments.PaymentType;

import java.io.Serializable;

/**
 * Offline Payment DTO used to communicate with Decidir's Payment Service
 */
public abstract class Offline implements Serializable {
    private Long id = 0L;
    private Currency currency;
    private Long amount;
    private String site_transaction_id;
    private Integer payment_method_id;
    private PaymentType payment_type; // single / distributed
    protected String payment_mode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getSite_transaction_id() {
        return site_transaction_id;
    }

    public void setSite_transaction_id(String site_transaction_id) {
        this.site_transaction_id = site_transaction_id;
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

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }
}
