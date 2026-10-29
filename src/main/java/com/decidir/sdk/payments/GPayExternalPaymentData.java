package com.decidir.sdk.payments;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GPayExternalPaymentData {

    @JsonProperty("integration_type")
    private String integrationType;

    @JsonProperty("signature")
    private String signature;

    @JsonProperty("intermediate_signing_key")
    private IntermediateSigningKey intermediateSigningKey;

    @JsonProperty("protocol_version")
    private String protocolVersion;

    @JsonProperty("signed_message")
    private String signedMessage;

    // Getters y Setters
    public String getIntegrationType() {
        return integrationType;
    }

    public void setIntegrationType(String integrationType) {
        this.integrationType = integrationType;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public IntermediateSigningKey getIntermediateSigningKey() {
        return intermediateSigningKey;
    }

    public void setIntermediateSigningKey(IntermediateSigningKey intermediateSigningKey) {
        this.intermediateSigningKey = intermediateSigningKey;
    }

    public String getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getSignedMessage() {
        return signedMessage;
    }

    public void setSignedMessage(String signedMessage) {
        this.signedMessage = signedMessage;
    }
}