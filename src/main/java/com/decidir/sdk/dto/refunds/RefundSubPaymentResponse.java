package com.decidir.sdk.dto.refunds;

import java.io.Serializable;

import com.decidir.sdk.dto.CardError;
import com.decidir.sdk.dto.Status;

/**
 * Created by biandra on 22/09/16.
 */
public class RefundSubPaymentResponse implements Serializable {

    private Long id;
    private Long amount;
    private Long refund_id;
    private CardError error;
    private Status status;

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

    public Long getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(Long refund_id) {
        this.refund_id = refund_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public CardError getError() {
        return error;
    }

    public void setError(CardError error) {
        this.error = error;
    }
}
