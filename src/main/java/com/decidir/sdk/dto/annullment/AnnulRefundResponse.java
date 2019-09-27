package com.decidir.sdk.dto.annullment;

import java.io.Serializable;

import com.decidir.sdk.dto.CardError;
import com.decidir.sdk.dto.Status;

/**
 * Created by biandra on 22/09/16.
 */
public class AnnulRefundResponse implements Serializable {
    
    private Long amount;
    private CardError error;
    private Status status;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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
