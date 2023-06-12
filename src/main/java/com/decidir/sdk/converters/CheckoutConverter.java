package com.decidir.sdk.converters;

import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.checkout.CheckoutResponse;

import retrofit2.Response;

public class CheckoutConverter extends DecidirConverter {
	
	public DecidirResponse<CheckoutResponse> convert(Response<CheckoutResponse> response, CheckoutResponse checkoutResponse) {
        DecidirResponse<CheckoutResponse> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setResult(checkoutResponse);
        dResponse.setMessage(response.message());
        return dResponse;
    }
}
