package com.decidir.sdk.dto.refunds;

import java.io.Serializable;

/**
 * Created by biandra on 05/10/16.
 */
public class RefundSubPayment implements Serializable {

    private Long id;
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
