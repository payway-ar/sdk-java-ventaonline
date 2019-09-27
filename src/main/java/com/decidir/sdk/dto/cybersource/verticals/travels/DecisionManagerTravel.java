package com.decidir.sdk.dto.cybersource.verticals.travels;

import java.io.Serializable;

/**
 * Created by ivalek on 11/06/17.
 */
public class DecisionManagerTravel implements Serializable {

	private String complete_route;
	private JourneyType journey_type;
	private DepartureDate departure_date;
	
	public String getComplete_route() {
		return complete_route;
	}
	public void setComplete_route(String complete_route) {
		this.complete_route = complete_route;
	}
	public JourneyType getJourney_type() {
		return journey_type;
	}
	public void setJourney_type(JourneyType journey_type) {
		this.journey_type = journey_type;
	}
	public DepartureDate getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(DepartureDate departure_date) {
		this.departure_date = departure_date;
	}
	
}
