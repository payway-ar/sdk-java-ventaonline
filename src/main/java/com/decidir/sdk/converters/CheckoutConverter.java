package com.decidir.sdk.converters;

import java.io.IOException;

import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.checkout.CheckoutResponse;
import com.decidir.sdk.dto.checkout.history.HistoryResponse;
import com.decidir.sdk.exceptions.CheckoutError;
import com.decidir.sdk.exceptions.CheckoutHistoryError;
import com.decidir.sdk.exceptions.CheckoutHistoryValidationError;
import com.decidir.sdk.exceptions.CheckoutValidationError;

import retrofit2.Response;

public class CheckoutConverter extends DecidirConverter {
	
	public DecidirResponse<CheckoutResponse> convert(Response<CheckoutResponse> response, CheckoutResponse checkoutResponse) {
        DecidirResponse<CheckoutResponse> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setResult(checkoutResponse);
        dResponse.setMessage(response.message());
        return dResponse;
    }

	public DecidirResponse<HistoryResponse> convert(Response<HistoryResponse> response, HistoryResponse historyResponse) {
		DecidirResponse<HistoryResponse> dResponse = new DecidirResponse();
		dResponse.setStatus(response.code());
		dResponse.setResult(historyResponse);
		dResponse.setMessage(response.message());
		return dResponse;
	}
	 public DecidirResponse<CheckoutError> convert(Response response) throws IOException {
	        DecidirResponse<CheckoutError> dResponse = new DecidirResponse();
	        dResponse.setStatus(response.code());
	        dResponse.setResult(super.convert(response.errorBody().bytes(), CheckoutError.class));
	        dResponse.setMessage(response.message());
	        return dResponse;
	    }
	 
	 public DecidirResponse<CheckoutValidationError> convertValidationError(Response response) throws IOException {
		DecidirResponse<CheckoutValidationError> dResponse = new DecidirResponse();
		dResponse.setStatus(response.code());
		dResponse.setResult(super.convert(response.errorBody().bytes(), CheckoutValidationError.class));
		dResponse.setMessage(response.message());
		return dResponse;
	}

	public DecidirResponse<CheckoutHistoryValidationError> convertCheckoutHistoryValidationError(Response response) throws IOException {
		DecidirResponse<CheckoutHistoryValidationError> dResponse = new DecidirResponse();
		dResponse.setStatus(response.code());
		dResponse.setResult(super.convert(response.errorBody().bytes(), CheckoutHistoryValidationError.class));
		dResponse.setMessage(response.message());
		return dResponse;
	}

	public DecidirResponse<CheckoutHistoryError> convertCheckoutHistoryError(Response response) throws IOException {
		DecidirResponse<CheckoutHistoryError> dResponse = new DecidirResponse();
		dResponse.setStatus(response.code());
		dResponse.setResult(super.convert(response.errorBody().bytes(), CheckoutHistoryError.class));
		dResponse.setMessage(response.message());
		return dResponse;
	}
}
