package com.decidir.sdk.services;

import java.io.IOException;

import com.decidir.sdk.converters.CheckoutConverter;
import com.decidir.sdk.converters.ErrorConverter;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.checkout.CheckoutRequest;
import com.decidir.sdk.dto.checkout.CheckoutResponse;
import com.decidir.sdk.exceptions.CheckoutError;
import com.decidir.sdk.exceptions.CheckoutException;
import com.decidir.sdk.exceptions.CheckoutValidationError;
import com.decidir.sdk.exceptions.CheckoutValidationException;
import com.decidir.sdk.exceptions.DecidirException;
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

}