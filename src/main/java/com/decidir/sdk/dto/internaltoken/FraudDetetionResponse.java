package com.decidir.sdk.dto.internaltoken;

public class FraudDetetionResponse {
    private String status;
    private Boolean send_to_cs;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getSend_to_cs() {
        return send_to_cs;
    }

    public void setSend_to_cs(Boolean send_to_cs) {
        this.send_to_cs = send_to_cs;
    }
}
