package com.decidir.sdk.dto.cybersource.verticals.travels;

import java.io.Serializable;

public class DepartureDate implements Serializable {

	private String departure_time;
	private String departure_zone;
	
	public String getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}
	public String getDeparture_zone() {
		return departure_zone;
	}
	public void setDeparture_zone(String departure_zone) {
		this.departure_zone= departure_zone;
	}

}