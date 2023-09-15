package com.decidir.sdk.exceptions;

import com.decidir.sdk.exceptions.responses.ResponseException;

public class CheckoutException extends RuntimeException implements ResponseException<CheckoutError> {

    private int status;
    private String message;
    private CheckoutError response;

    public CheckoutException(int status, String message, CheckoutError response) {
        this.status = status;
        this.message = message;
        this.response = response;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public CheckoutError getResponse() {
        return response;
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

    public void setResponse(CheckoutError response) {
        this.response = response;
    }
}
