package com.decidir.sdk.exceptions;

/**
 * Created by biandra on 08/07/16.
 */
public class NotFoundException extends DecidirException{

    private NotFoundError errorDetail;

    public NotFoundException(int status, String message, NotFoundError errorDetail) {
        super();
        this.setStatus(status);
        this.setMessage(message);
        this.errorDetail = errorDetail;
    }

    public NotFoundError getErrorDetail() {
        return errorDetail;
    }
}
