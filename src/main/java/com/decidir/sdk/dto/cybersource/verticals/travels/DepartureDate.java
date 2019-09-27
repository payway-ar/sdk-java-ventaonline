package com.decidir.sdk.dto.cybersource.verticals.travels;

import java.io.Serializable;
import java.util.Date;

public class DepartureDate implements Serializable {

	private Date departure_time;
	private String departure_zone;
	
	public Date getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(Date departure_time) {
		this.departure_time = departure_time;
	}
	public String getDeparture_zone() {
		return departure_zone;
	}
	public void setDeparture_zone(String departure_zone) {
		this.departure_zone= departure_zone;
	}

}