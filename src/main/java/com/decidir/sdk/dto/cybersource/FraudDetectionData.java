package com.decidir.sdk.dto.cybersource;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Fraud Detection Request and response interface 
 */
@JsonDeserialize(as=FraudDetectionDataResponse.class)
public interface FraudDetectionData extends Serializable {

}
