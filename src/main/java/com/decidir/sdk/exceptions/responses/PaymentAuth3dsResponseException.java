package com.decidir.sdk.exceptions.responses;

import com.decidir.sdk.dto.payments.PaymentResponse;
import com.decidir.sdk.dto.payments.threeds.PaymentAuth3dsResponse;

/**
 * Created by lschinini
 */
public class PaymentAuth3dsResponseException extends RuntimeException implements ResponseException<PaymentResponse>{

    private int status;
    private String message;
    private PaymentAuth3dsResponse paymentResponse;

    public PaymentAuth3dsResponseException(int status, String message, PaymentAuth3dsResponse paymentResponse){
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
    public PaymentAuth3dsResponse getResponse() {
        return this.paymentResponse;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setPaymentResponse(PaymentAuth3dsResponse paymentResponse) {
        this.paymentResponse = paymentResponse;
    }
}
