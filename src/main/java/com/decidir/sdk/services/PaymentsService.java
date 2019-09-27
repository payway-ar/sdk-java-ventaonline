package com.decidir.sdk.services;

import java.io.IOException;

import com.decidir.sdk.converters.ErrorConverter;
import com.decidir.sdk.converters.PaymentConverter;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.payments.Page;
import com.decidir.sdk.dto.payments.PaymentRequest;
import com.decidir.sdk.dto.payments.PaymentResponse;
import com.decidir.sdk.dto.payments.agro.AgroPaymentRequestNoPCI;
import com.decidir.sdk.dto.payments.agro.AgroPaymentResponse;
import com.decidir.sdk.dto.payments.bsa.BSAPaymentRequestPCI;
import com.decidir.sdk.dto.payments.bsa.BSAPaymentResponse;
import com.decidir.sdk.dto.payments.gds.GDSPaymentRequestNoPCI;
import com.decidir.sdk.dto.payments.gds.GDSPaymentRequestPCI;
import com.decidir.sdk.dto.payments.gds.GDSPaymentResponse;
import com.decidir.sdk.dto.payments.offline.OfflinePaymentRequest;
import com.decidir.sdk.dto.payments.offline.OfflinePaymentRequestPCI;
import com.decidir.sdk.dto.payments.offline.OfflinePaymentResponse;
import com.decidir.sdk.dto.payments.pci.PaymentPciRequest;
import com.decidir.sdk.dto.payments.pci.PaymentPciTokenRequest;
import com.decidir.sdk.exceptions.DecidirError;
import com.decidir.sdk.exceptions.DecidirException;
import com.decidir.sdk.exceptions.responses.PaymentException;
import com.decidir.sdk.resources.PaymentApi;

import retrofit2.Response;

/**
 * Created by biandra on 06/07/16.
 */
public class PaymentsService {

	public static final int HTTP_500 = 500;
	private PaymentApi paymentApi;
	private PaymentConverter paymentConverter;
	private ErrorConverter errorConverter;

	private PaymentsService(PaymentApi paymentApi, PaymentConverter paymentConverter, ErrorConverter errorConverter) {
		this.paymentApi = paymentApi;
		this.paymentConverter = paymentConverter;
		this.errorConverter = errorConverter;
	}

	public static PaymentsService getInstance(PaymentApi paymentApi) {
		return new PaymentsService(paymentApi, new PaymentConverter(), new ErrorConverter());
	}

	public DecidirResponse<Page> getPayments(Integer offset, Integer pageSize, String siteOperationId, String siteId) {
		try {
			Response<Page> response = this.paymentApi.getPayments(offset, pageSize, siteOperationId, siteId).execute();
			if (response.isSuccessful()) {
				return paymentConverter.convert(response, response.body());
			}

			DecidirResponse<DecidirError> error = errorConverter.convert(response);
			throw DecidirException.wrap(error.getStatus(), error.getMessage(), error.getResult());
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<PaymentResponse> paymentNoPci(PaymentRequest payment) throws PaymentException {
		try {
			Response<PaymentResponse> response = this.paymentApi.payNoPci(payment).execute();
			return paymentConverter.convertOrThrowSpecError(response, PaymentException.class, PaymentResponse.class);
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<PaymentResponse> paymentPciCard(PaymentPciRequest payment) throws PaymentException {
		try {
			Response<PaymentResponse> response = this.paymentApi.payPciCard(payment).execute();
			return paymentConverter.convertOrThrowSpecError(response, PaymentException.class, PaymentResponse.class);
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<PaymentResponse> paymentPciToken(PaymentPciTokenRequest payment) throws PaymentException {
		try {
			Response<PaymentResponse> response = this.paymentApi.payPciToken(payment).execute();
			return paymentConverter.convertOrThrowSpecError(response, PaymentException.class, PaymentResponse.class);
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<PaymentResponse> getPayment(Long paymentId) throws PaymentException {
		try {
			Response<PaymentResponse> response = this.paymentApi.getPayment(paymentId).execute();
			return paymentConverter.convertOrThrowSpecError(response, PaymentException.class, PaymentResponse.class);
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<OfflinePaymentResponse> offlinePayment(OfflinePaymentRequest offlinePayment) throws PaymentException {
		try {
			Response<OfflinePaymentResponse> response = this.paymentApi.payOffline(offlinePayment).execute();
			return paymentConverter.convertOrThrowSpecError(response, PaymentException.class, PaymentResponse.class);
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<GDSPaymentResponse> gdsPaymentNoPci(GDSPaymentRequestNoPCI gdsPayment) throws PaymentException {
		try {
			Response<GDSPaymentResponse> response = this.paymentApi.payGdsNoPci(gdsPayment).execute();
			return paymentConverter.convertOrThrowSpecError(response, PaymentException.class, PaymentResponse.class);
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<GDSPaymentResponse> gdsPaymentPciCard(GDSPaymentRequestPCI gdsPayment) throws PaymentException {
		try {
			Response<GDSPaymentResponse> response = this.paymentApi.payGdsPci(gdsPayment).execute();
			return paymentConverter.convertOrThrowSpecError(response, PaymentException.class, PaymentResponse.class);
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<BSAPaymentResponse> bsaPaymentRequestPCI(BSAPaymentRequestPCI bsaPaymentRequestPCI) throws PaymentException {
		try {
			Response<BSAPaymentResponse> response = this.paymentApi.payBsaPci(bsaPaymentRequestPCI).execute();
			return paymentConverter.convertOrThrowSpecError(response, PaymentException.class, PaymentResponse.class);
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<AgroPaymentResponse> agroPaymentRequestNoPCI(
			AgroPaymentRequestNoPCI agroPaymentRequestNoPCI) throws PaymentException {
		try {
			Response<AgroPaymentResponse> response = this.paymentApi.payAgroNoPci(agroPaymentRequestNoPCI).execute();
			return paymentConverter.convertOrThrowSpecError(response, PaymentException.class, PaymentResponse.class);
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<OfflinePaymentResponse> offlinePCIPayment(
			OfflinePaymentRequestPCI offlinePaymentRequestPCI) throws PaymentException {
		try {
			Response<OfflinePaymentResponse> response = this.paymentApi.payOfflinePCI(offlinePaymentRequestPCI)
					.execute();
			return paymentConverter.convertOrThrowSpecError(response, PaymentException.class, PaymentResponse.class);
		} catch (IOException  ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}
}
