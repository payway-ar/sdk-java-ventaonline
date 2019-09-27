package com.decidir.sdk.dto.forms;

import com.decidir.sdk.dto.payments.Customer;

import java.io.Serializable;

/**
 * Created by biandra on 19/06/17.
 */
public class DataForm implements Serializable {

    private SiteForm site;
    private Customer customer;
    private PaymentForm payment;
    private String success_url;
    private String cancel_url;

    public SiteForm getSite() {
        return site;
    }

    public void setSite(SiteForm site) {
        this.site = site;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PaymentForm getPayment() {
        return payment;
    }

    public void setPayment(PaymentForm payment) {
        this.payment = payment;
    }

    public String getSuccess_url() {
        return success_url;
    }

    public void setSuccess_url(String success_url) {
        this.success_url = success_url;
    }

    public String getCancel_url() {
        return cancel_url;
    }

    public void setCancel_url(String cancel_url) {
        this.cancel_url = cancel_url;
    }
}
