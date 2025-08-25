package com.decidir.sdk.dto.payments;

import java.io.Serializable;

public class SubPaymentResponse extends SubPayment implements Serializable {

    private String tid;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
