package com.decidir.sdk.exceptions.responses;

import com.decidir.sdk.dto.auth3ds.Auth3dsResponse;

public class Instruction3dsException extends RuntimeException implements ResponseException<Auth3dsResponse> {
	
	private static final long serialVersionUID = 1L;
	private int status;
    private String message;
    private Auth3dsResponse instruction3dsResponse;
    
	public Instruction3dsException(int status, String message, Auth3dsResponse instruction3dsResponse) {
		this.status = status;
		this.message = message;
		this.instruction3dsResponse = instruction3dsResponse;
	}

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public Auth3dsResponse getResponse() {
		return instruction3dsResponse;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Auth3dsResponse getInstruction3dsResponse() {
		return instruction3dsResponse;
	}

	public void setInstruction3dsResponse(Auth3dsResponse instruction3dsResponse) {
		this.instruction3dsResponse = instruction3dsResponse;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

}
