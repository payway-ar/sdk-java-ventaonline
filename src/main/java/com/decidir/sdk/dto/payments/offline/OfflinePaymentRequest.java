package com.decidir.sdk.dto.payments.offline;

import com.decidir.sdk.payments.Offline;

/**
 * DTO Offline Payment no PCI used to communicate with Decidir's Payment Service
 * <br>
 * <br>
 * <strong>Usage example</strong>
 * <pre>
 * {@code ...
 * OfflinePaymentRequest offlinePaymentRequest = new OfflinePaymentRequest();
 * offlinePaymentRequest.setToken("f522e031-90cb-41ed-ba1f-46e813e8e789"); //offline payment token
 * //common offline payment data - i.e. see {@link OfflinePayment}
 * offlinePaymentRequest.setSite_transaction_id("0001234");
 * offlinePaymentRequest.setPayment_method_id(15); //mastercard
 * offlinePaymentRequest.setAmount(23250L);//Amount in cents: $232.50
 * offlinePaymentRequest.setCurrency(Currency.ARS);
 * offlinePaymentRequest.setCod_p1("123")
 * ...
 * }
 * </pre>
 */
public class OfflinePaymentRequest extends Offline {

    private String token;
    private Integer bank_id;
    private String email;
    private String invoice_expiration;
    private String second_invoice_expiration;
    private String cod_p1;
    private String cod_p2;
    private String cod_p3;
    private String cod_p4;
    private String client;
    private Long surcharge;

    public OfflinePaymentRequest() {
        this.setPayment_mode("offline");
    }

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInvoice_expiration() {
        return invoice_expiration;
    }

    public void setInvoice_expiration(String invoice_expiration) {
        this.invoice_expiration = invoice_expiration;
    }

    public String getSecond_invoice_expiration() {
        return second_invoice_expiration;
    }

    public void setSecond_invoice_expiration(String second_invoice_expiration) {
        this.second_invoice_expiration = second_invoice_expiration;
    }

    public String getCod_p1() {
        return cod_p1;
    }

    public void setCod_p1(String cod_p1) {
        this.cod_p1 = cod_p1;
    }

    public String getCod_p2() {
        return cod_p2;
    }

    public void setCod_p2(String cod_p2) {
        this.cod_p2 = cod_p2;
    }

    public String getCod_p3() {
        return cod_p3;
    }

    public void setCod_p3(String cod_p3) {
        this.cod_p3 = cod_p3;
    }

    public String getCod_p4() {
        return cod_p4;
    }

    public void setCod_p4(String cod_p4) {
        this.cod_p4 = cod_p4;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Long getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Long surcharge) {
        this.surcharge = surcharge;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
