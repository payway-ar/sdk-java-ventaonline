package com.decidir.sdk.dto.cybersource.verticals.travels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PassengerStatus {
	
	STANDARD,
	GOLD,
	PLATINUM;
	
    @JsonCreator
    public static PassengerStatus forValue(String value) throws IllegalArgumentException {
    	for (PassengerStatus ps : PassengerStatus.values()) {
    		if (ps.name().equalsIgnoreCase(value)) return ps;
    	}
    	throw new IllegalArgumentException("Undefined Passenger Status for: " + value);
    }

    @Override
    @JsonValue
    public String toString() {
       return this.name().toLowerCase();
    }

}
