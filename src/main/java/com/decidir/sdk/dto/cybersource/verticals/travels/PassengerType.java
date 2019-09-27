package com.decidir.sdk.dto.cybersource.verticals.travels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PassengerType {

	ADULT("ADT"),
	CHILD("CNN"),
	INFANT("INF"),
	YOUTH("YTH"),
	STUDENT("STU"),
	SENIOR_CITIZEN("SCR"),
	MILITARY("MIL");
	
	private String abbreviature;
	
	private PassengerType(String abbreviature) {
		this.abbreviature = abbreviature;
	}
	
	@JsonValue
	public String getAbbreviature() {
		return this.abbreviature;
	}
	
    @JsonCreator
    public static PassengerType forValue(String value) throws IllegalArgumentException {
    	for (PassengerType pt : PassengerType.values()) {
    		if (pt.getAbbreviature().equalsIgnoreCase(value)) return pt;
    	}
    	throw new IllegalArgumentException("Undefined Passenger Type for: " + value);
    }

}
