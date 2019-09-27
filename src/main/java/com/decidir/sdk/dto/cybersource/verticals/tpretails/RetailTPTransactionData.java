package com.decidir.sdk.dto.cybersource.verticals.tpretails;

import com.decidir.sdk.dto.cybersource.Account;
import com.decidir.sdk.dto.cybersource.Item;
import com.decidir.sdk.dto.cybersource.ShippingData;
import com.decidir.sdk.dto.cybersource.verticals.Wallet;

import java.io.Serializable;
import java.util.List;

public class RetailTPTransactionData implements Serializable {

    private Account account;
    private Wallet wallet_account;
    private Integer enroled_card_quantity;
    private Integer double_factor_tp;
    private Integer payment_method_risk_level;
    private ShippingData ship_to;
    private String days_to_delivery;
    private Boolean tax_voucher_required;
    private String customer_loyality_number;
    private String coupon_code;
    private List<Item> items;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Wallet getWallet_account() {
        return wallet_account;
    }

    public void setWallet_account(Wallet wallet_account) {
        this.wallet_account = wallet_account;
    }

    public Integer getEnroled_card_quantity() {
        return enroled_card_quantity;
    }

    public void setEnroled_card_quantity(Integer enroled_card_quantity) {
        this.enroled_card_quantity = enroled_card_quantity;
    }

    public Integer getDouble_factor_tp() {
        return double_factor_tp;
    }

    public void setDouble_factor_tp(Integer double_factor_tp) {
        this.double_factor_tp = double_factor_tp;
    }

    public Integer getPayment_method_risk_level() {
        return payment_method_risk_level;
    }

    public void setPayment_method_risk_level(Integer payment_method_risk_level) {
        this.payment_method_risk_level = payment_method_risk_level;
    }

    public ShippingData getShip_to() {
        return ship_to;
    }

    public void setShip_to(ShippingData ship_to) {
        this.ship_to = ship_to;
    }

    public String getDays_to_delivery() {
        return days_to_delivery;
    }

    public void setDays_to_delivery(String days_to_delivery) {
        this.days_to_delivery = days_to_delivery;
    }

    public Boolean getTax_voucher_required() {
        return tax_voucher_required;
    }

    public void setTax_voucher_required(Boolean tax_voucher_required) {
        this.tax_voucher_required = tax_voucher_required;
    }

    public String getCustomer_loyality_number() {
        return customer_loyality_number;
    }

    public void setCustomer_loyality_number(String customer_loyality_number) {
        this.customer_loyality_number = customer_loyality_number;
    }

    public String getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(String coupon_code) {
        this.coupon_code = coupon_code;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
