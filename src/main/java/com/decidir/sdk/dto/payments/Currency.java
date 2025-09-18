package com.decidir.sdk.dto.payments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Currency {

    ARS("ars"),
    USD("usd");

    private String currencyId;

    private Currency(final String currencyId) {
        this.currencyId = currencyId;
    }

    @JsonCreator
    public static Currency forValue(String value) {
        for (Currency currency : Currency.values()) {
            if (currency.currencyId.equalsIgnoreCase(value)) {
                return currency;
            }
        }

        return null;
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
