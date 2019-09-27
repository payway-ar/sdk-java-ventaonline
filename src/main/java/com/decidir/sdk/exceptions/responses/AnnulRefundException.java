package com.decidir.sdk.exceptions.responses;

import com.decidir.sdk.dto.annullment.AnnulRefundResponse;

/**
 * Created by biandra on 08/07/16.
 */
public class AnnulRefundException extends RuntimeException implements ResponseException<AnnulRefundResponse>{

    private int status;
    private String message;
    private AnnulRefundResponse annulRefundResponse;

    public AnnulRefundException(int status, String message, AnnulRefundResponse annulRefundResponse){
        this.status = status;
        this.message = message;
        this.annulRefundResponse = annulRefundResponse;
    }

    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public AnnulRefundResponse getResponse() {
        return this.annulRefundResponse;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AnnulRefundResponse getAnnulRefundResponse() {
        return annulRefundResponse;
    }

    public void setAnnulRefundResponse(AnnulRefundResponse annulRefundResponse) {
        this.annulRefundResponse = annulRefundResponse;
    }

}
