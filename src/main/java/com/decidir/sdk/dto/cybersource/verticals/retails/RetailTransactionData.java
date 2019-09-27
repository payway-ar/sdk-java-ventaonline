package com.decidir.sdk.dto.cybersource.verticals.retails;

import com.decidir.sdk.dto.cybersource.Item;
import com.decidir.sdk.dto.cybersource.ShippingData;

import java.io.Serializable;
import java.util.List;

public class RetailTransactionData implements Serializable {

	private ShippingData ship_to;
	private String days_to_delivery;
	private Boolean tax_voucher_required;
	private String customer_loyality_number;
	private String coupon_code;
	private List<Item> items;

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
