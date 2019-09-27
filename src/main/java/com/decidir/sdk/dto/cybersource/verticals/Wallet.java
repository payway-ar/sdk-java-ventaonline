package com.decidir.sdk.dto.cybersource.verticals;

import java.io.Serializable;

public class Wallet implements Serializable {

    private String id;
    private Integer antiquity;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAntiquity() {
        return antiquity;
    }

    public void setAntiquity(Integer antiquity) {
        this.antiquity = antiquity;
    }
}
