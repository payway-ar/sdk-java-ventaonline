package com.decidir.sdk.dto.payments;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ezequiel on 21/6/16.
 */
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PaymentType {

    SINGLE,
    DISTRIBUTED;

    private static Map<String, PaymentType> paymentTypeMap = new HashMap(2);
    static {
        paymentTypeMap.put("single", SINGLE);
        paymentTypeMap.put("distributed", DISTRIBUTED);
    }

    @JsonCreator
    public static PaymentType forValue(String value) {
        return paymentTypeMap.get(value.toLowerCase());
    }


    @JsonValue
    public String toValue() {
        for (Map.Entry<String, PaymentType> entry : paymentTypeMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }
        return null;
    }
}
