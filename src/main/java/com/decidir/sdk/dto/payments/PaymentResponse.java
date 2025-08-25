package com.decidir.sdk.dto.payments;

import java.io.Serializable;
import java.util.List;

import com.decidir.sdk.dto.Status;
import com.decidir.sdk.dto.StatusDetails;
import com.decidir.sdk.dto.auth3ds.Auth3dsResponse;
import com.decidir.sdk.dto.cybersource.FraudDetectionDataResponse;
import com.decidir.sdk.payments.Payment;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * DTO Payment response used to communicate with Decidir's Payment Service 
 */
@JsonInclude(Include.NON_NULL)
public class PaymentResponse extends Payment implements Serializable {

	private String date;
	private String date_created;
	private String date_approved;
	private String date_last_updated;
	private Status status;
	private StatusDetails status_details;
	@JsonInclude(Include.ALWAYS)
	private ConfirmedPaymentData confirmed;
	@JsonInclude(Include.ALWAYS)
	private String pan;
	@JsonInclude(Include.ALWAYS)
	private String customer_token;
	private Auth3dsResponse auth_3ds_response;
	private String card_brand;
	@JsonInclude(Include.ALWAYS)
	private Customer customer;
	@JsonInclude(Include.ALWAYS)
	private String first_installment_expiration_date;
	@JsonInclude(Include.ALWAYS)
	private FraudDetectionDataResponse fraud_detection;
    @JsonInclude(Include.ALWAYS)
    private List<SubPaymentResponse> sub_payments;
	@JsonInclude(Include.ALWAYS)
	private AggregatorResponse aggregate_data;
	private String establishment_name;
	@JsonInclude(Include.ALWAYS)
	private Spv spv;
	private String token;
	private Object card_data;
	private String tid;

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public String getDate_approved() {
		return date_approved;
	}

	public void setDate_approved(String date_approved) {
		this.date_approved = date_approved;
	}

	public String getDate_last_updated() {
		return date_last_updated;
	}

	public void setDate_last_updated(String date_last_updated) {
		this.date_last_updated = date_last_updated;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public StatusDetails getStatus_details() {
		return status_details;
	}

	public void setStatus_details(StatusDetails status_details) {
		this.status_details = status_details;
	}

	public ConfirmedPaymentData getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(ConfirmedPaymentData confirmed) {
		this.confirmed = confirmed;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getCustomer_token() {
		return customer_token;
	}

	public void setCustomer_token(String customer_token) {
		this.customer_token = customer_token;
	}

	public Auth3dsResponse getAuth_3ds_response() {
		return auth_3ds_response;
	}

	public void setAuth_3ds_response(Auth3dsResponse auth_3ds_response) {
		this.auth_3ds_response = auth_3ds_response;
	}

	public Object getCard_data() {return card_data;}

	public void setCard_data(Object card_data) {this.card_data = card_data;}

	public String getCard_brand() {return card_brand;}

	public void setCard_brand(String card_brand) {this.card_brand = card_brand;}

	@Override
	public Customer getCustomer() {return customer;}

	@Override
	public void setCustomer(Customer customer) {this.customer = customer;}

	@Override
	public String getFirst_installment_expiration_date() {return first_installment_expiration_date;}

	@Override
	public void setFirst_installment_expiration_date(String first_installment_expiration_date) {this.first_installment_expiration_date = first_installment_expiration_date;}

    public List<SubPaymentResponse> getSub_payments() {
        return sub_payments;
    }

    public void setSub_payments(List<SubPaymentResponse> sub_payments) {
        this.sub_payments = sub_payments;
    }

	@Override
	public FraudDetectionDataResponse getFraud_detection() {return fraud_detection;}

	public void setFraud_detection(FraudDetectionDataResponse fraud_detection) {this.fraud_detection = fraud_detection;}

	public AggregatorResponse getAggregate_data() {return aggregate_data;}

	public void setAggregate_data(AggregatorResponse aggregate_data) {this.aggregate_data = aggregate_data;}

	@Override
	public String getEstablishment_name() {return establishment_name;}

	@Override
	public void setEstablishment_name(String establishment_name) {this.establishment_name = establishment_name;}

	public Spv getSpv() {return spv;}

	public void setSpv(Spv spv) {this.spv = spv;}
}
