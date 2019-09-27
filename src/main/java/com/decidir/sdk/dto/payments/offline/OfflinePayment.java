package com.decidir.sdk.dto.payments.offline;


import com.decidir.sdk.dto.payments.Currency;
import com.decidir.sdk.dto.payments.PaymentType;

import java.io.Serializable;

/**
 * Offline Payment DTO used to communicate with Decidir's Payment Service
 */

public abstract class OfflinePayment implements Serializable{
    private Long id = 0L;
    private Integer bank_id;
    private String site_transaction_id;
    private Integer payment_method_id;
    private Long amount;
    private Currency currency;
    private PaymentType payment_type; // single / distributed
    private String email;
    private String invoice_expiration;
    private String second_invoice_expiration;
    private String cod_p1;
    private String cod_p2;
    private String cod_p3;
    private String cod_p4;
    private String client;
    private Long surcharge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSite_transaction_id() {
        return site_transaction_id;
    }

    public void setSite_transaction_id(String site_transaction_id) {
        this.site_transaction_id = site_transaction_id;
    }

    public Integer getPayment_method_id() {
        return payment_method_id;
    }

    public void setPayment_method_id(Integer payment_method_id) {
        this.payment_method_id = payment_method_id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public PaymentType getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(PaymentType payment_type) {
        this.payment_type = payment_type;
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

    public Integer getBank_id() {
        return bank_id;
    }

    public void setBank_id(Integer bank_id) {
        this.bank_id = bank_id;
    }
}
