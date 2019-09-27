package com.decidir.sdk.exceptions.responses;

import com.decidir.sdk.dto.refunds.RefundPaymentResponse;

/**
 * Created by biandra on 08/07/16.
 */
public class RefundException extends RuntimeException implements ResponseException<RefundPaymentResponse>{

    private int status;
    private String message;
    private RefundPaymentResponse refundPaymentResponse;

    public RefundException(int status, String message, RefundPaymentResponse refundPaymentResponse){
        this.status = status;
        this.message = message;
        this.refundPaymentResponse = refundPaymentResponse;
    }



    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public int getStatus() {
        return this.status;
    }

    @Override
    public RefundPaymentResponse getResponse() {
        return this.refundPaymentResponse;
    }
}
