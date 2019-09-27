package com.decidir.sdk.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by biandra on 06/10/16.
 */
public enum Operation {

    ANNULMENT,
    REFUND,
    REFUND_ACCREDITATION,
    ANNULMENT_REFUND,
    ANNULMENT_REFUND_ACCREDITATION,
    UNDEFINED;

    private static Map<String, Operation> operationMap = new HashMap(6);
    static {
        operationMap.put("anulacion", ANNULMENT);
        operationMap.put("devolucion", REFUND);
        operationMap.put("devolucion de acreditacion", REFUND_ACCREDITATION);
        operationMap.put("anulacion de devolucion", ANNULMENT_REFUND);
        operationMap.put("anulacion de dev ya acreditada", ANNULMENT_REFUND_ACCREDITATION);
        operationMap.put("undefined", UNDEFINED);
    }

    @JsonCreator
    public static Operation forValue(String value) {
        Operation operation = operationMap.get(value.toLowerCase());
        return operation != null ? operation : UNDEFINED;
    }


    @JsonValue
    public String toValue() {
        for (Map.Entry<String, Operation> entry : operationMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }
        return null;
    }
}
