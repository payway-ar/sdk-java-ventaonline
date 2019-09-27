package com.decidir.sdk.dto.cybersource.verticals.travels;

import java.io.Serializable;

public class Passenger implements Serializable {

	private String email;
	private String first_name;
	private String last_name;
	private String passport_id;
	private String phone;
	private PassengerStatus passenger_status;
	private PassengerType passenger_type;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPassport_id() {
		return passport_id;
	}
	public void setPassport_id(String passport_id) {
		this.passport_id = passport_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public PassengerStatus getPassenger_status() {
		return passenger_status;
	}
	public void setPassenger_status(PassengerStatus passenger_status) {
		this.passenger_status = passenger_status;
	}
	public PassengerType getPassenger_type() {
		return passenger_type;
	}
	public void setPassenger_type(PassengerType passenger_type) {
		this.passenger_type = passenger_type;
	}
	
	
}
