package com.decidir.sdk.resources;

import com.decidir.sdk.dto.tokens.Token;
import com.decidir.sdk.dto.tokens.TokenResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TokenApi {
	
	@POST("tokens")
	Call <TokenResponse> token (@Body Token tokenReq);

}
