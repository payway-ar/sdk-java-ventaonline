package com.decidir.sdk.exceptions;

import com.decidir.sdk.exceptions.responses.ResponseException;

public class CheckoutValidationException extends RuntimeException implements ResponseException<CheckoutValidationError> {

    private int status;
    private String message;
    private CheckoutValidationError response;

    public CheckoutValidationException(int status, String message, CheckoutValidationError response) {
        this.status = status;
        this.message = message;
        this.response = response;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public CheckoutValidationError getResponse() {
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

    public void setResponse(CheckoutValidationError response) {
        this.response = response;
    }
}
