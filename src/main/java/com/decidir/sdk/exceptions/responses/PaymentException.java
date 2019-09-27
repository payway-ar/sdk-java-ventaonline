package com.decidir.sdk.exceptions.responses;

import com.decidir.sdk.dto.payments.PaymentResponse;

/**
 * Created by biandra on 08/07/16.
 */
public class PaymentException extends RuntimeException implements ResponseException<PaymentResponse>{

    private int status;
    private String message;
    private PaymentResponse paymentResponse;

    public PaymentException(int status, String message, PaymentResponse paymentResponse){
        this.status = status;
        this.message = message;
        this.paymentResponse = paymentResponse;
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
    public PaymentResponse getResponse() {
        return this.paymentResponse;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPaymentResponse(PaymentResponse paymentResponse) {
        this.paymentResponse = paymentResponse;
    }
}
