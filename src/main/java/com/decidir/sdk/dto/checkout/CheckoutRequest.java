package com.decidir.sdk.dto.checkout;

public class CheckoutRequest {
    private String id;
    private String origin_platform;
    private String payment_description;
    private CheckoutProductModel [] products;
	private double total_price;
    private String site;
    private String success_url;
    private String redirect_url;
    private String cancel_url;
    private String notifications_url;
    private String life_time;
    private String template_id;
    private int [] installments;
    private String id_payment_method;
    private boolean plan_gobierno;
	
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
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
	
	
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	
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
	
	
	public String getLife_time() {
		return life_time;
	}
	public void setLife_time(String life_time) {
		this.life_time = life_time;
	}
	
	
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	
	
	public int[] getInstallments() {
		return installments;
	}
	public void setInstallments(int[] installments) {
		this.installments = installments;
	}
	
	
	public String getId_payment_method() {
		return id_payment_method;
	}
	public void setId_payment_method(String id_payment_method) {
		this.id_payment_method = id_payment_method;
	}
	
	
	public boolean getPlan_gobierno() {
		return plan_gobierno;
	}
	public void setPlan_gobierno(boolean plan_gobierno) {
		this.plan_gobierno = plan_gobierno;
	}
	
	

}
