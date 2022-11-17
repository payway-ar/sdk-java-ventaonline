package com.decidir.sdk.dto.instruction3ds;

import java.io.Serializable;

public class Instruction3dsData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String instruction_value;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInstruction_value() {
		return instruction_value;
	}
	public void setInstruction_value(String instruction_value) {
		this.instruction_value = instruction_value;
	}
	
}
