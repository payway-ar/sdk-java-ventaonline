package com.decidir.sdk.dto.auth3ds;

public class Auth3dsResponse {
	
	private String id;
	private String status;
	private String authentication_value;
	private String commerce_indicator;
	private String protocol_version;
	private String directory_server_transaction_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAuthentication_value() {
		return authentication_value;
	}
	public void setAuthentication_value(String authentication_value) {
		this.authentication_value = authentication_value;
	}
	public String getCommerce_indicator() {
		return commerce_indicator;
	}
	public void setCommerce_indicator(String commerce_indicator) {
		this.commerce_indicator = commerce_indicator;
	}
	public String getProtocol_version() {
		return protocol_version;
	}
	public void setProtocol_version(String protocol_version) {
		this.protocol_version = protocol_version;
	}
	public String getDirectory_server_transaction_id() {
		return directory_server_transaction_id;
	}
	public void setDirectory_server_transaction_id(String directory_server_transaction_id) {
		this.directory_server_transaction_id = directory_server_transaction_id;
	}
	
	

}
