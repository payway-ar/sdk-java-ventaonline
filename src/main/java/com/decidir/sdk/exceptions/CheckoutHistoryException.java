package com.decidir.sdk.exceptions;

import com.decidir.sdk.exceptions.responses.ResponseException;

public class CheckoutHistoryException extends RuntimeException implements ResponseException<CheckoutHistoryError> {

    private int status;
    private String message;
    private CheckoutHistoryError response;

    public CheckoutHistoryException(int status, String message, CheckoutHistoryError response) {
        this.status = status;
        this.message = message;
        this.response = response;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public CheckoutHistoryError getResponse() {
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

    public void setResponse(CheckoutHistoryError response) {
        this.response = response;
    }
}
