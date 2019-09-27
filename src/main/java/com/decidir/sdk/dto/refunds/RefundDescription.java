package com.decidir.sdk.dto.refunds;

import java.io.Serializable;

import com.decidir.sdk.dto.Operation;
import com.decidir.sdk.dto.Status;

/**
 * Created by biandra on 06/10/16.
 */
public class RefundDescription implements Serializable {

    private Long id;
    private String date_created;
    private Long amount;
    private Status status;
    private String date_canceled;
    private Operation operation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

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

    public String getDate_canceled() {
        return date_canceled;
    }

    public void setDate_canceled(String date_canceled) {
        this.date_canceled = date_canceled;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
