package com.decidir.sdk.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by biandra on 12/07/16.
 */
public enum Status {

    APPROVED,
    PRE_APPROVED,
    APPROVED_WITH_REFUND,
    REJECTED,
    REVIEW,
    REFUNDED,
    ANNULLED,
    ACCREDITED,
    ANNULMENT_APPROVED,
    REFUND_APPROVED,
    GROUP_REJECTED,
    GROUP_ANNULLED,
    INVOICE_GENERATED,
    INVOICE_NOT_GENERATED,
    REVERSED,
    ADHERED,
    CANCELLED, // status for cancelled refunds
    UNDEFINED;

    private static Map<String, Status> statusMap = new HashMap(13);
    static {
        statusMap.put("approved", APPROVED);
        statusMap.put("pre_approved", PRE_APPROVED);
        statusMap.put("approved_with_refund", APPROVED_WITH_REFUND);
        statusMap.put("rejected", REJECTED);
        statusMap.put("review", REVIEW);
        statusMap.put("refunded", REFUNDED);
        statusMap.put("annulled", ANNULLED);
        statusMap.put("accredited", ACCREDITED);
        statusMap.put("annulment_approved", ANNULMENT_APPROVED);
        statusMap.put("refund_approved", REFUND_APPROVED);
        statusMap.put("group_rejected", GROUP_REJECTED);
        statusMap.put("group_annulled", GROUP_ANNULLED);
        statusMap.put("invoice_generated", INVOICE_GENERATED);
        statusMap.put("invoice_not_generated", INVOICE_NOT_GENERATED);
        statusMap.put("reversed", REVERSED);
        statusMap.put("adhered", ADHERED);
        statusMap.put("cancelled", CANCELLED);
        statusMap.put("undefined", UNDEFINED);
    }

    @JsonCreator
    public static Status forValue(String value) {
        Status status = statusMap.get(value.toLowerCase());
        return status != null ? status : UNDEFINED ;
    }


    @JsonValue
    public String toValue() {
        for (Map.Entry<String, Status> entry : statusMap.entrySet()) {
            if (entry.getValue() == this)
                return entry.getKey();
        }
        return null;
    }

}
