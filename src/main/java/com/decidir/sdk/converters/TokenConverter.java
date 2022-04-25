package com.decidir.sdk.converters;

import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.tokens.TokenResponse;

import retrofit2.Response;

public class TokenConverter extends DecidirConverter {
	
	public DecidirResponse<TokenResponse> convert(Response<TokenResponse> response, TokenResponse token) {
        DecidirResponse<TokenResponse> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setResult(token);
        dResponse.setMessage(response.message());
        return dResponse;
    }
}
