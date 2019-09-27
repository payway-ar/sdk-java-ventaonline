package com.decidir.sdk.dto.payments.gds;

import com.decidir.sdk.dto.payments.PaymentRequest;

public class GDSPaymentRequestNoPCI extends PaymentRequest{
    private String nro_location;
    private String iata_code;

    public GDSPaymentRequestNoPCI() {
        this.setPayment_mode("gds");
    }

    public String getNro_location() {
        return nro_location;
    }

    public void setNro_location(String nro_location) {
        this.nro_location = nro_location;
    }

    public String getIata_code() {
        return iata_code;
    }

    public void setIata_code(String iata_code) {
        this.iata_code = iata_code;
    }
}
