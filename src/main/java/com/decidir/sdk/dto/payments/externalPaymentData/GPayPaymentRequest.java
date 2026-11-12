package com.decidir.sdk.dto.payments.externalPaymentData;

import com.decidir.sdk.dto.payments.SubPayment;
import com.decidir.sdk.payments.GPayExternalPaymentData;
import com.decidir.sdk.payments.Payment;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * DTO Payment Request with external payment data such as Google Pay (GPay)
 * used to communicate with Decidir's Payment Service.
 * <br>
 * <br>
 * <strong>Usage example</strong>
 * <pre>
 * {@code
 * ExpPaymentRequest paymentRequest = new ExpPaymentRequest();
 *
 * // Common payment data - i.e. see {@link Payment}
 * paymentRequest.setSite_transaction_id("TX:SIMPLE:VISA:1781624064");
 * paymentRequest.setPayment_method_id(1); // Visa
 * paymentRequest.setAmount(10000000L); // Amount in cents
 * paymentRequest.setCurrency("ars");
 * paymentRequest.setInstallments(1);
 * paymentRequest.setDescription("Cypress - Transacciones");
 * paymentRequest.setPayment_type("single");
 * paymentRequest.setEstablishment_name("Transacciones // +* 25");
 *
 * // Set fraud detection data
 * FraudDetectionDataRequest fraud_detection = new FraudDetectionDataRequest();
 * fraud_detection.setSend_to_cs(false);
 * paymentRequest.setFraud_detection(fraud_detection);
 *
 * // Set GPay External Payment Data
 * GPayExternalPaymentData externalPaymentData = new GPayExternalPaymentData();
 * externalPaymentData.setIntegration_type("gpay");
 * externalPaymentData.setSignature("MEUCIELyCcUwWdbwn5R7/o65mikFiAtqGGJv7ppdCKwCXFtaAiEAl1wGCuen43vE5W0qZxGvjtiPxpYWfRZ5hqj4WdMRi9I=");
 * externalPaymentData.setProtocol_version("ECv2");
 * externalPaymentData.setSigned_message("{\"encryptedMessage\":\"jr4E...\",\"ephemeralPublicKey\":\"BAh...\",\"tag\":\"7LAj...\"}");
 *
 * IntermediateSigningKey signingKey = new IntermediateSigningKey();
 * signingKey.setSigned_key("{\"keyValue\":\"MFkw...\",\"keyExpiration\":\"1784976910156\"}");
 * signingKey.setSignatures(Arrays.asList("MEUCIBbQHIpjdstDgGeYV5SPzzKZniL3kT1pIhU+ScMwNI/WAiEAuNjzioZjL6gOyHqz2qT7RjFS18gbtlbc+LnbiKGDl5k="));
 * externalPaymentData.setIntermediate_signing_key(signingKey);
 *
 * paymentRequest.setExternal_payment_data(externalPaymentData);
 * }
 * </pre>
 */
public class GPayPaymentRequest extends Payment {

    private List<SubPayment> sub_payments;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private GPayExternalPaymentData external_payment_data;

    public List<SubPayment> getSub_payments() {
        return sub_payments;
    }

    public void setSub_payments(List<SubPayment> sub_payments) {
        this.sub_payments = sub_payments;
    }

	public GPayExternalPaymentData getExternal_payment_data() {
		return external_payment_data;
	}

	public void setExternal_payment_data(GPayExternalPaymentData external_payment_data) {
		this.external_payment_data = external_payment_data;
	}
}
