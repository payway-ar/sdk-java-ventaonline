package com.decidir.sdk.dto.payments.pci;

import com.decidir.sdk.dto.payments.Spv;
import com.decidir.sdk.dto.payments.SubPayment;
import com.decidir.sdk.dto.cybersource.FraudDetectionDataRequest;
import com.decidir.sdk.payments.Payment;

import java.util.List;

/**
 * DTO Payment PCI with card data used to communicate with Decidir's Payment Service 
 * <br>
 * <br>
 * <strong>Usage example</strong>
 * <pre>
 * {@code ...
 * PaymentPciRequest paymentRequest = new PaymentPciRequest();
 * CardData card_data = ... // {@link CardData }
 * paymentRequest.setCard_data(card_data);  
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

public class PaymentPciRequest extends Payment {

	private CardData card_data;
	private Boolean is_tokenized_payment;
	private CardTokenData token_card_data;
	private Spv spv;

	//Getters & Setters
	public Spv getSpv() {return spv;}
	public void setSpv(Spv spv) {this.spv = spv;}
	public CardData getCard_data() { return card_data; }
	public void setCard_data(CardData card_data) { this.card_data = card_data; }
	public Boolean getIs_tokenized_payment() { return is_tokenized_payment; }
	public CardTokenData getToken_card_data() {return token_card_data;}
    private List<SubPayment> sub_payments;


	//is_tokenized_payment Indicates if the transaction is tokenized or not & token_card_data Only if is_tokenized_payment is true
	public void setIs_tokenized_payment(Boolean is_tokenized_payment) {
		this.is_tokenized_payment = is_tokenized_payment;
		if (!is_tokenized_payment) {
			this.token_card_data = null;
		}
	}

	//is_tokenized_payment Indicates if the transaction is tokenized or not & token_card_data Only if is_tokenized_payment is true
	public void setToken_card_data(CardTokenData token_card_data) {
		if (this.is_tokenized_payment && token_card_data == null) {
			throw new IllegalArgumentException("card_token_data is required for tokenized payments");
		}
		this.token_card_data = token_card_data;
	}

    public List<SubPayment> getSub_payments() {
        return sub_payments;
    }

    public void setSub_payments(List<SubPayment> sub_payments) {
        this.sub_payments = sub_payments;
    }
}

