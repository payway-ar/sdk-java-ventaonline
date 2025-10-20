package com.decidir.sdk.dto.payments;

import java.io.Serializable;

public class AggregatorResponse extends Aggregator implements Serializable {

	private Boolean enabled;

	public Boolean getEnabled() {
        return enabled;
    }

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
