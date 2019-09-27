package com.decidir.sdk.exceptions;

/**
 * Created by jmejia 06/09/2018
 */
public class ValidateStatusException extends DecidirException{

    private ValidateStatusError errorDetail;

    public ValidateStatusException(int status, String message, ValidateStatusError errorDetail) {
        super();
        this.setStatus(status);
        this.setMessage(message);
        this.errorDetail = errorDetail;
    }

    public ValidateStatusError getErrorDetail() {
        return errorDetail;
    }
}
