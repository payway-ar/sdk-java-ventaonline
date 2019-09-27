package com.decidir.sdk.dto.cybersource.verticals.travels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum JourneyType {
	ONE_WAY("one way"),
	ROUND_TRIP("round trip");

	private String value;
	
	private JourneyType(String value) {
		this.value= value;
	}
	
	@JsonValue
	public String getValue() {
		return this.value;
	}
	
    @JsonCreator
    public static JourneyType forValue(String value) throws IllegalArgumentException {
    	for (JourneyType jt : JourneyType.values()) {
    		if (jt.getValue().equalsIgnoreCase(value)) return jt;
    	}
    	throw new IllegalArgumentException("Undefined Journey Type for: " + value);
    }
}
