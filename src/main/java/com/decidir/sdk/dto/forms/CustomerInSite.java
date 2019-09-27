package com.decidir.sdk.dto.forms;

import java.io.Serializable;

/**
 * Created by biandra on 21/06/16.
 */
public class CustomerInSite implements Serializable{

    private Integer days_in_site;
    private Boolean is_guest;
    private String password;
    private Integer num_of_transactions;
    private String cellphone_number;
    private String date_of_birth;
    private String street;

    public Integer getDays_in_site() {
        return days_in_site;
    }

    public void setDays_in_site(Integer days_in_site) {
        this.days_in_site = days_in_site;
    }

    public Boolean getIs_guest() {
        return is_guest;
    }

    public void setIs_guest(Boolean is_guest) {
        this.is_guest = is_guest;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNum_of_transactions() {
        return num_of_transactions;
    }

    public void setNum_of_transactions(Integer num_of_transactions) {
        this.num_of_transactions = num_of_transactions;
    }

    public String getCellphone_number() {
        return cellphone_number;
    }

    public void setCellphone_number(String cellphone_number) {
        this.cellphone_number = cellphone_number;
    }

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}
