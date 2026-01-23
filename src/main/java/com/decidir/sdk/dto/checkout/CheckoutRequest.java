package com.decidir.sdk.dto.checkout;

public class CheckoutRequest {
	private String origin_platform;
	private String payment_description;
	private CheckoutProductModel[] products;
	private double total_price;
	private String site;
	private String success_url;
	private String redirect_url;
	private String cancel_url;
	private String notifications_url;
	private Integer template_id;
	private int[] installments;
	private Integer id_payment_method;
	private boolean plan_gobierno;
	private String public_apikey;
	private Integer establishment_number;
	private String cuit;
	private String currency;
	private CheckoutFraudDetectionDataRequest fraud_detection;


	public String getOrigin_platform() {
		return origin_platform;
	}
	public void setOrigin_platform(String origin_platform) {
		this.origin_platform = origin_platform;
	}


	public String getPayment_description() {
		return payment_description;
	}
	public void setPayment_description(String payment_description) {
		this.payment_description = payment_description;
	}
	public CheckoutProductModel[] getProducts() {
		return products;
	}

	public void setProducts(CheckoutProductModel[] products) {
		this.products = products;
	}

	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}


	public String getSite() { return site; }
	public void setSite(String site) { this.site = site; }


	public String getSuccess_url() {
		return success_url;
	}
	public void setSuccess_url(String success_url) {
		this.success_url = success_url;
	}


	public String getRedirect_url() {
		return redirect_url;
	}
	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}


	public String getCancel_url() {
		return cancel_url;
	}
	public void setCancel_url(String cancel_url) {
		this.cancel_url = cancel_url;
	}


	public String getNotifications_url() {
		return notifications_url;
	}
	public void setNotifications_url(String notifications_url) {
		this.notifications_url = notifications_url;
	}


	public Integer getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(Integer template_id) {
		this.template_id = template_id;
	}


	public int[] getInstallments() {
		return installments;
	}
	public void setInstallments(int[] installments) {
		this.installments = installments;
	}


	public Integer getId_payment_method() {
		return id_payment_method;
	}
	public void setId_payment_method(Integer id_payment_method) {
		this.id_payment_method = id_payment_method;
	}


	public boolean getPlan_gobierno() {
		return plan_gobierno;
	}
	public void setPlan_gobierno(boolean plan_gobierno) {
		this.plan_gobierno = plan_gobierno;
	}

	public String getPublic_apikey() {
		return public_apikey;
	}

	public void setPublic_apikey(String public_apikey) {
		this.public_apikey = public_apikey;
	}

	public int getEstablisment_number() { return establishment_number; }
	public void setEstablishment_number(Integer establishment_number) { this.establishment_number = establishment_number; }

	public String getCuit() { return cuit; }
	public void setCuit (String cuit) { this.cuit = cuit; }

	public String getCurrency() { return currency; }
	public void setCurrency (String currency) { this.currency = currency; }

	public CheckoutFraudDetectionDataRequest getFraud_detection() {
		return fraud_detection;
	}

	public void setFraud_detection(CheckoutFraudDetectionDataRequest fraud_detection) {
		this.fraud_detection = fraud_detection;
	}

}
