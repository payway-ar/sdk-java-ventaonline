package com.decidir.sdk.exceptions;

import com.decidir.sdk.exceptions.responses.ResponseException;

public class CheckoutHistoryValidationException extends RuntimeException implements ResponseException<CheckoutHistoryValidationError> {

    private int status;
    private String message;
    private CheckoutHistoryValidationError response;

    public CheckoutHistoryValidationException(int status, String message, CheckoutHistoryValidationError response) {
        this.status = status;
        this.message = message;
        this.response = response;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public CheckoutHistoryValidationError getResponse() {
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

    public void setResponse(CheckoutHistoryValidationError response) {
        this.response = response;
    }
}
