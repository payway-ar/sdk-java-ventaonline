package com.decidir.sdk.converters;

import com.decidir.sdk.dto.DecidirResponse;

import com.decidir.sdk.resources.PaymentTokenResponse;

import retrofit2.Response;

public class PaymentTokenConverter extends DecidirConverter {
	
	public DecidirResponse<PaymentTokenResponse> convert(Response<PaymentTokenResponse> response, PaymentTokenResponse token) {
        DecidirResponse<PaymentTokenResponse> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setResult(token);
        dResponse.setMessage(response.message());
        return dResponse;
    }
}
