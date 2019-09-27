package com.decidir.sdk.dto.cybersource;

import java.io.Serializable;

public class Item implements Serializable {

	private String code;
	private String description;
	private String name;
	private String sku;
	private Long total_amount;
	private Integer quantity;
	private Long unit_price;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Long getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(Long total_amount) {
		this.total_amount = total_amount;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Long getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(Long unit_price) {
		this.unit_price = unit_price;
	}
}
