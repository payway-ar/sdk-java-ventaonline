package com.decidir.sdk.dto.payments;


public class Spv {

    private String client_id;
    private String identificator;
    private InstallmentSpv installment;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getIdentificator() {
        return identificator;
    }

    public void setIdentificator(String identificator) {
        this.identificator = identificator;
    }

    public InstallmentSpv getInstallment() {
        return installment;
    }

    public void setInstallment(InstallmentSpv installment) {
        this.installment = installment;
    }
}
