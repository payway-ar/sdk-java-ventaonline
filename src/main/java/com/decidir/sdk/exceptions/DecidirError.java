package com.decidir.sdk.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    private String message;

    private String details;

    public String getError_type() {
        return error_type;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
        if (this.error_type == null) {
            this.error_type = "api_error";
        }
    }

    public String getMessage() {
        return message;
    }

    @JsonProperty("details")
    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

    public DecidirException toException(int status, String defaultHttpMessage) {
        String finalMessage = defaultHttpMessage;

        if (this.message != null && !this.message.isEmpty()) {
            finalMessage = this.message;

            if (this.details != null && !this.details.isEmpty()) {
                finalMessage += " (" + this.details.replace("\n", " | ") + ")";
            }
        }

        return new DecidirException(status, finalMessage);
    }
}
