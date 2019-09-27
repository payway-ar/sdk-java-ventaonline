package com.decidir.sdk.dto.cybersource;

import com.decidir.sdk.dto.payments.Currency;

import java.io.Serializable;

/**
 * Created by biandra on 21/06/16.
 */
public class PurchaseTotals implements Serializable{

    private Currency currency;
    private Long amount;

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
}
