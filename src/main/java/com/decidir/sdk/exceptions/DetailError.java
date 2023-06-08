package com.decidir.sdk.exceptions;

import java.io.Serializable;

public class DetailError implements Serializable {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DetailError{" +
                "description='" + description + '\'' +
                '}';
    }
}
