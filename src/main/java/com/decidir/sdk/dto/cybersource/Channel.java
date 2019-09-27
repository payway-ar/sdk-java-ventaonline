package com.decidir.sdk.dto.cybersource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by biandra on 21/06/16.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Channel {

	WEB("Web"),
	MOBILE("Mobile"),
	TEL("Telefonica");

	private final String channelId;

	Channel(String channelId) {

		this.channelId = channelId;
	}

	public boolean isChannel(String c) {
		return this.channelId.equals(c);
	}

	@JsonCreator
	public static Channel forValue(String value) {
		Channel[] values = values();
		Channel result = null;

		for (int i = 0; i < values.length; i++) {
			if (values[i].isChannel(value)) {
				result = values[i];
			}
		}
		return result;
	}

	@JsonValue
	public String toValue() {

		return this.channelId;
	}
}
