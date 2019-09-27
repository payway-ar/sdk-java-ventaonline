package com.decidir.sdk.dto.cybersource.verticals.services;

import com.decidir.sdk.dto.cybersource.Item;

import java.io.Serializable;
import java.util.List;

public class ServicesTransactionData implements Serializable {

    private String service_type;
    private String reference_payment_service1;
    private String reference_payment_service2;
    private String reference_payment_service3;
    private List<Item> items;

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getReference_payment_service1() {
        return reference_payment_service1;
    }

    public void setReference_payment_service1(String reference_payment_service1) {
        this.reference_payment_service1 = reference_payment_service1;
    }

    public String getReference_payment_service2() {
        return reference_payment_service2;
    }

    public void setReference_payment_service2(String reference_payment_service2) {
        this.reference_payment_service2 = reference_payment_service2;
    }

    public String getReference_payment_service3() {
        return reference_payment_service3;
    }

    public void setReference_payment_service3(String reference_payment_service3) {
        this.reference_payment_service3 = reference_payment_service3;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}

