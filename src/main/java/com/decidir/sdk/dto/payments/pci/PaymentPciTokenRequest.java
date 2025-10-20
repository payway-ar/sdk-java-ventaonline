package com.decidir.sdk.dto.payments.pci;

import com.decidir.sdk.dto.payments.SubPayment;
import com.decidir.sdk.dto.cybersource.FraudDetectionDataRequest;
import com.decidir.sdk.payments.Payment;

import java.util.List;

/**
 * DTO Payment with token data used to communicate with Decidir's Payment Service 
 * 
 * <br>
 * <br>
 * <strong>Usage example</strong>
 * <pre>
 * {@code ...
 * PaymentPciTokenRequest paymentRequest = new PaymentPciTokenRequest();
 * CardTokenData card_token_data = ... // {@link CardTokenData }
 * paymentRequest.setCard_token_data(card_token_data);
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
public class PaymentPciTokenRequest extends Payment {

	private CardTokenData card_token_data;
    private List<SubPayment> sub_payments;


	public CardTokenData getCard_token_data() {
		return card_token_data;
	}

	public void setCard_token_data(CardTokenData card_token_data) {
		this.card_token_data = card_token_data;
	}

    public List<SubPayment> getSub_payments() {
        return sub_payments;
    }

    public void setSub_payments(List<SubPayment> sub_payments) {
        this.sub_payments = sub_payments;
    }
}
