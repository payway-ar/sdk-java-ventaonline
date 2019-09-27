package com.decidir.sdk.dto.payments.pci;

/**
 * Specific card token data DTO required for PCI payments
*/
public class CardTokenData extends PCICardData {

	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
