package com.decidir.sdk.dto.payments.offline;

import com.decidir.sdk.dto.payments.Identification;

import java.io.Serializable;

public class OfflineCustomer implements Serializable {

    private String name;
    private Identification identification;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }
}
