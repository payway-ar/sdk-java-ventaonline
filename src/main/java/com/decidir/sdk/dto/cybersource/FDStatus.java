package com.decidir.sdk.dto.cybersource;

import com.decidir.sdk.dto.ErrorType;

import java.io.Serializable;

/**
 * Fraud detection result status
 * Created by biandra on 28/06/16.
 */
public class FDStatus implements Serializable {

    private String decision;
    private String request_id;
    private String reason_code;
    private String description;
    private ErrorType details;
    
    private Review review;

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public String getReason_code() {
        return reason_code;
    }

    public void setReason_code(String reason_code) {
        this.reason_code = reason_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ErrorType getDetails() {
        return details;
    }

    public void setDetails(ErrorType details) {
        this.details = details;
    }

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
}
