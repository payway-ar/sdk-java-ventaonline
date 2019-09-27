package com.decidir.sdk.dto.payments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by ezequiel on 21/6/16.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Currency {

    ARS("ars");

    private String  currencyId;

    private Currency(final String currencyId) {
        this.currencyId = currencyId;
    }

    @JsonCreator
    public static Currency forValue(String value) {

        return Currency.ARS;
    }

    @JsonValue
    public String toValue() {

        return Currency.ARS.name();
    }
}
