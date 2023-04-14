package com.decidir.sdk.dto.payments.pci;

/**
 * Specific card token data DTO required for PCI payments
c * @JsonProperty("token_card_data")
*/
public class CardTokenData extends PCICardData {

	private String token;
	private String eci;
	private String cryptogram;

	public String getEci() { return eci; }
	public void setEci(String eci) { this.eci = eci; }
	public String getCryptogram() { return cryptogram; }
	public void setCryptogram(String cryptogram) { this.cryptogram = cryptogram; }
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
