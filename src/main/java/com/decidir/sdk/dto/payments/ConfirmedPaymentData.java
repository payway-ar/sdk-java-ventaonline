package com.decidir.sdk.dto.payments;

import java.io.Serializable;

/**
 * Created by biandra on 25/11/16.
 */
public class ConfirmedPaymentData implements Serializable {

    private Long id;
    private Long origin_amount;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrigin_amount() {
        return origin_amount;
    }

    public void setOrigin_amount(Long origin_amount) {
        this.origin_amount = origin_amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
