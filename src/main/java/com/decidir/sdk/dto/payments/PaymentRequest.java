package com.decidir.sdk.dto.payments;

import com.decidir.sdk.dto.cybersource.FraudDetectionDataRequest;
import com.decidir.sdk.payments.Payment;

import java.util.List;

/**
 * DTO Payment no PCI used to communicate with Decidir's Payment Service 
 * <br>
 * <br>
 * <strong>Usage example</strong>
 * <pre>
 * {@code ...
 * PaymentRequest paymentRequest = new PaymentRequest();
 * paymentRequest.setToken("f522e031-90cb-41ed-ba1f-46e813e8e789"); //payment token
 * //common payment data - i.e. see {@link Payment }
 * paymentRequest.setSite_transaction_id("0001234");
 * paymentRequest.setUser_id("client_username");
 * paymentRequest.setPayment_method_id(15); //mastercard
 * paymentRequest.setBin("53236");
 * paymentRequest.setAmount(23250L);//Amount in cents: $232.50 
 * paymentRequest.setCurrency(Currency.ARS);
 * paymentRequest.setInstallments(1);
 * paymentRequest.setPayment_type(PaymentType.SINGLE);
 * List<SubPayment> sub_payments = ... //List of {@link SubPayment }
 * paymentRequest.setSub_payments(sub_payments);
 * FraudDetectionData fraud_detection = ... // {@link FraudDetectionDataRequest }
 * paymentRequest.setFraud_detection(fraud_detection);
 * ...
 * }
 * </pre>
 */
public class PaymentRequest extends Payment {

	private String token;
	private Spv spv;
    private List<SubPayment> sub_payments;

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Spv getSpv() {return spv;}
	public void setSpv(Spv spv) {this.spv = spv;}

    public List<SubPayment> getSub_payments() {
        return sub_payments;
    }

    public void setSub_payments(List<SubPayment> sub_payments) {
        this.sub_payments = sub_payments;
    }
}
