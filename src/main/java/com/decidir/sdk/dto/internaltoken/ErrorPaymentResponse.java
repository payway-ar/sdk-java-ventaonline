package com.decidir.sdk.dto.internaltoken;

public class ErrorPaymentResponse {
    private String type;
    private ReasonResponse reason;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ReasonResponse getReason() {
        return reason;
    }

    public void setReason(ReasonResponse reason) {
        this.reason = reason;
    }
}
