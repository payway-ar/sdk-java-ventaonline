package com.decidir.sdk.exceptions;

import java.io.Serializable;
import java.util.Arrays;

public class InternalTokenError implements Serializable {
    private String title;
    private String description;
    private String code;
    private String type;
    private DetailError[] details;
    private String trace_id;
    private String span_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrace_id() {
        return trace_id;
    }

    public void setTrace_id(String trace_id) {
        this.trace_id = trace_id;
    }

    public String getSpan_id() {
        return span_id;
    }

    public void setSpan_id(String span_id) {
        this.span_id = span_id;
    }

    public DetailError[] getDetails() {
        return details;
    }

    public void setDetails(DetailError[] details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "InternalTokenError{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", details=" + Arrays.toString(details) +
                ", trace_id='" + trace_id + '\'' +
                ", span_id='" + span_id + '\'' +
                '}';
    }
}
