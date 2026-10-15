package com.decidir.sdk.services;

import java.io.IOException;

import com.decidir.sdk.converters.CheckoutConverter;
import com.decidir.sdk.converters.ErrorConverter;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.checkout.CheckoutRequest;
import com.decidir.sdk.dto.checkout.CheckoutResponse;
import com.decidir.sdk.dto.checkout.history.HistoryRequest;
import com.decidir.sdk.dto.checkout.history.HistoryResponse;
import com.decidir.sdk.exceptions.*;
import com.decidir.sdk.resources.CheckoutApi;

import retrofit2.Response;

public class CheckoutService {

	public static final int HTTP_500 = 500;
	public static final int HTTP_402 = 402;
	private CheckoutApi checkoutApi;
	private CheckoutConverter checkoutConverter;
	private ErrorConverter errorConverter;

	private CheckoutService(CheckoutApi checkoutApi, CheckoutConverter checkoutConverter, ErrorConverter errorConverter) {
		this.checkoutApi = checkoutApi;
		this.checkoutConverter = checkoutConverter;
		this.errorConverter = errorConverter;
	}

	public static CheckoutService getInstance(CheckoutApi checkoutApi) {
		return new CheckoutService(checkoutApi, new CheckoutConverter(), new ErrorConverter());
	}

	public DecidirResponse<CheckoutResponse> checkoutHash(CheckoutRequest checkoutRequest) {
		try {
			Response<CheckoutResponse> response = this.checkoutApi.checkoutHash(checkoutRequest).execute();
			if (response.isSuccessful()) {
				return checkoutConverter.convert(response, response.body());
			}
			
			if (response.code() == 412) {
				DecidirResponse<CheckoutError> error = checkoutConverter.convert(response);
				throw new CheckoutException(error.getStatus(), error.getMessage(), error.getResult());
			}
			
			DecidirResponse<CheckoutValidationError> error = checkoutConverter.convertValidationError(response);
			throw new CheckoutValidationException(error.getStatus(), error.getMessage(), error.getResult());
			
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<HistoryResponse> getHistory(HistoryRequest request){

		try {
			Response<HistoryResponse> response = this.checkoutApi.getHistory(request.getCuit(), request.getSiteId(),request.getOperationId(),request.getStatus(),request.getFromDate(),request.getToDate(),request.getPlatform(),request.getPage(),request.getItemsPerPage(),request.getDescription(),request.getCurrency(),request.getEstablishmentNumber(),request.getMaxAmount(),request.getMinAmount(),request.getInstallments(),request.getPaymentMethodId()).execute();
			if (response.isSuccessful()) {
				return checkoutConverter.convert(response, response.body());
			}

			if (response.code() == 500) {
				DecidirResponse<CheckoutHistoryError> error = checkoutConverter.convertCheckoutHistoryError(response);
				throw new CheckoutHistoryException(error.getStatus(), error.getMessage(), error.getResult());
			}

			DecidirResponse<CheckoutHistoryValidationError> error = checkoutConverter.convertCheckoutHistoryValidationError(response);
			throw new CheckoutHistoryValidationException(error.getStatus(), error.getResult().getParam(), error.getResult());

		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

}