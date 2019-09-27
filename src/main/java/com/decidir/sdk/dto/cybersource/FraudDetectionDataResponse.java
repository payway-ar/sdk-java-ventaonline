package com.decidir.sdk.dto.cybersource;

import java.util.List;

/**
 * Represents the general status returned for fraud detection data 
 * and its error details
 */
public class FraudDetectionDataResponse implements FraudDetectionData {

	private FDStatus status;
	
	private List<Csmdd> csmdds;

	public FDStatus getStatus() {
		return status;
	}

	public void setStatus(FDStatus status) {
		this.status = status;
	}

	public List<Csmdd> getCsmdds() {
		return csmdds;
	}

	public void setCsmdds(List<Csmdd> csmdds) {
		this.csmdds = csmdds;
	}
}
