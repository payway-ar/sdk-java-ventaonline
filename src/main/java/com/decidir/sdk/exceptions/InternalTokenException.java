package com.decidir.sdk.exceptions;

import com.decidir.sdk.exceptions.responses.ResponseException;

public class InternalTokenException extends RuntimeException implements ResponseException<InternalTokenError> {

    private int status;
    private String message;
    private InternalTokenError response;

    public InternalTokenException(int status, String message, InternalTokenError response) {
        this.status = status;
        this.message = message;
        this.response = response;
    }

    @Override
    public int getStatus() {
        return status;
    }

    @Override
    public InternalTokenError getResponse() {
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

    public void setResponse(InternalTokenError response) {
        this.response = response;
    }
}
