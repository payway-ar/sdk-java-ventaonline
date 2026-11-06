package com.decidir.sdk.payments;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GPayExternalPaymentData {

    @JsonProperty("integration_type")
    private String integration_type;

    @JsonProperty("signature")
    private String signature;

    @JsonProperty("intermediate_signing_key")
    private IntermediateSigningKey intermediate_signing_key;

    @JsonProperty("protocol_version")
    private String protocol_version;

    @JsonProperty("signed_message")
    private String signed_message;

    // Getters y Setters
    public String getIntegrationType() {
        return integration_type;
    }

    public void setIntegrationType(String integrationType) {
        this.integration_type = integrationType;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public IntermediateSigningKey getIntermediateSigningKey() {
        return intermediate_signing_key;
    }

    public void setIntermediateSigningKey(IntermediateSigningKey intermediateSigningKey) {
        this.intermediate_signing_key = intermediateSigningKey;
    }

    public String getProtocolVersion() {
        return protocol_version;
    }

    public void setProtocolVersion(String protocolVersion) {
        this.protocol_version = protocolVersion;
    }

    public String getSignedMessage() {
        return signed_message;
    }

    public void setSignedMessage(String signedMessage) {
        this.signed_message = signedMessage;
    }
}