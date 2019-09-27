package com.decidir.sdk.dto.payments.agro;

import com.decidir.sdk.dto.payments.PaymentRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AgroPaymentRequestNoPCI extends PaymentRequest {
    @JsonProperty("installments")
    private List<InstallmentData> installmentList;
    private AgroData agro_data;
    private Boolean payment_method_is_agro;
    private int token_resolution_code;

    public AgroPaymentRequestNoPCI() {
        this.setPayment_mode("agro");
    }

    public Boolean getPayment_method_is_agro() {
        return payment_method_is_agro;
    }

    public void setPayment_method_is_agro(Boolean payment_method_is_agro) {
        this.payment_method_is_agro = payment_method_is_agro;
    }

    public int getToken_resolution_code() {
        return token_resolution_code;
    }

    public void setToken_resolution_code(int token_resolution_code) {
        this.token_resolution_code = token_resolution_code;
    }

    public List<InstallmentData> getInstallmentList() {
        return installmentList;
    }

    public void setInstallmentList(List<InstallmentData> installmentList) {
        this.installmentList = installmentList;
    }

    public AgroData getAgro_data() {
        return agro_data;
    }

    public void setAgro_data(AgroData agro_data) {
        this.agro_data = agro_data;
    }
}
