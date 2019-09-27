package com.decidir.sdk.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by biandra on 06/07/16.
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "error_type",
        visible = true,
        defaultImpl = ApiError.class)
@JsonSubTypes({
        @Type(value = ApiError.class, name = "api_connection_error"),
        @Type(value = ApiError.class, name = "authentication_error"),
        @Type(value = ApiError.class, name = "api_error"),
        @Type(value = ApiError.class, name = "rate_limit_error"),
        @Type(value = NotFoundError.class, name = "not_found_error"),
        @Type(value = ValidateStatusError.class, name = "invalid_status_error"),
        @Type(value = ValidateError.class, name = "invalid_request_error") })
public class DecidirError implements Serializable {

    private String error_type;

    public String getError_type() {
        return error_type;
    }

    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

    public DecidirException toException(int status, String message) {
        return new DecidirException(status, message);
    }
}
