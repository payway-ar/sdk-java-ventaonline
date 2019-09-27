package com.decidir.sdk.dto.cybersource;

import java.util.List;

import com.decidir.sdk.dto.cybersource.verticals.digitalgoods.DigitalGoodsFraudDetectionData;
import com.decidir.sdk.dto.cybersource.verticals.retails.RetailFraudDetectionData;
import com.decidir.sdk.dto.cybersource.verticals.ticketing.TicketingFraudDetectionData;
import com.decidir.sdk.dto.cybersource.verticals.travels.TravelFraudDetectionData;
import com.decidir.sdk.dto.forms.CustomerInSite;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

/**
 * Generic Fraud Detection Data DTO
 * Created by biandra on 21/06/16.
 */
@JsonSubTypes({
    @Type(value = RetailFraudDetectionData.class),
    @Type(value = TicketingFraudDetectionData.class),
    @Type(value = DigitalGoodsFraudDetectionData.class),
    @Type(value = TravelFraudDetectionData.class)})
public abstract class FraudDetectionDataRequest implements FraudDetectionData {

	private BillingData bill_to;
	private PurchaseTotals purchase_totals;
	private Channel channel;
	private String dispatch_method;
	private CustomerInSite customer_in_site;
	private CopyPasteCardData copy_paste_card_data;
	private Boolean send_to_cs;
	private String device_unique_id;
	private List<Csmdd> csmdds;

	public BillingData getBill_to() {
		return bill_to;
	}

	public void setBill_to(BillingData bill_to) {
		this.bill_to = bill_to;
	}

	public PurchaseTotals getPurchase_totals() {
		return purchase_totals;
	}

	public void setPurchase_totals(PurchaseTotals purchase_totals) {
		this.purchase_totals = purchase_totals;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public String getDispatch_method() {
		return dispatch_method;
	}

	public void setDispatch_method(String dispatch_method) {
		this.dispatch_method = dispatch_method;
	}

	public CustomerInSite getCustomer_in_site() {
		return customer_in_site;
	}

	public void setCustomer_in_site(CustomerInSite customer_in_site) {
		this.customer_in_site = customer_in_site;
	}

	public CopyPasteCardData getCopy_paste_card_data() {
		return copy_paste_card_data;
	}

	public void setCopy_paste_card_data(CopyPasteCardData copy_paste_card_data) {
		this.copy_paste_card_data = copy_paste_card_data;
	}

	public Boolean getSend_to_cs() {
		return send_to_cs;
	}

	public void setSend_to_cs(Boolean send_to_cs) {
		this.send_to_cs = send_to_cs;
	}

	public String getDevice_unique_id() {
		return device_unique_id;
	}

	public void setDevice_unique_id(String device_unique_id) {
		this.device_unique_id = device_unique_id;
	}

	public List<Csmdd> getCsmdds() {
		return csmdds;
	}

	public void setCsmdds(List<Csmdd> csmdds) {
		this.csmdds = csmdds;
	}
}
