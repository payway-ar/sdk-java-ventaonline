package com.decidir.sdk.exceptions;


/**
 * Created by biandra on 07/07/16.
 */
public class ApiError extends DecidirError {

    private String message;
    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public ApiException toException(int status, String message) {
        return new ApiException(status, message, this);
    }
}
