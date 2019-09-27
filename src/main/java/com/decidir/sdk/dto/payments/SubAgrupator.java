package com.decidir.sdk.dto.payments;

import java.io.Serializable;

/**
 * Created by gustavo on 7/1/18.
 */
public class SubAgrupator implements Serializable {

    private static final long serialVersionUID = 4497681374923923746L;

    private String indicator;
    private String identification_number;
    private String merchant_name;
    private String street;
    private String category;

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
