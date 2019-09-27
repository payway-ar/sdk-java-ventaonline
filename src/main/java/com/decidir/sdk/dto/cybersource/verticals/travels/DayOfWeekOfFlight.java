package com.decidir.sdk.dto.cybersource.verticals.travels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DayOfWeekOfFlight {
	
	SUNDAY(1),
	MONDAY(2),
	TUESDAY(3),
	WEDNESDAY(4),
	THURSDAY(5),
	FRIDAY(6),
	SATURDAY(7);
	
	private int value;
	
	private DayOfWeekOfFlight(int value) {
		this.value = value;
	}
	
	@JsonValue
	public int getValue() {
		return this.value;
	}
	
    @JsonCreator
    public static DayOfWeekOfFlight forValue(int value) throws IllegalArgumentException {
    	for (DayOfWeekOfFlight dow : DayOfWeekOfFlight.values()) {
    		if (dow.getValue() == value) return dow;
    	}
    	throw new IllegalArgumentException("Undefined day for: " + value);
    }



}
