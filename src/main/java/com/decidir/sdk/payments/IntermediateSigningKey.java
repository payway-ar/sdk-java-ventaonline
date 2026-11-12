package com.decidir.sdk.payments;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class IntermediateSigningKey {

    @JsonProperty("signed_key")
    private String signed_key;

    @JsonProperty("signatures")
    private List<String> signatures;

    // Getters y Setters
    public String getSignedKey() {
        return signed_key;
    }

    public void setSignedKey(String signedKey) {
        this.signed_key = signedKey;
    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<String> signatures) {
        this.signatures = signatures;
    }
}