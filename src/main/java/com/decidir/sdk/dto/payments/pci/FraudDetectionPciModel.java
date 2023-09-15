package com.decidir.sdk.dto.payments.pci;

import com.decidir.sdk.dto.cybersource.FraudDetectionData;

/** Specific data DTO required for PCI payments * @JsonProperty("fraud_detection") */

public class FraudDetectionPciModel implements FraudDetectionData {

    private Boolean send_to_cs;

    public Boolean getSendToCs() { return send_to_cs; }
    public void setSendToCs(Boolean send_to_cs) { this.send_to_cs = send_to_cs; }
}
