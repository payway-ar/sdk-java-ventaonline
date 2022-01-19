package com.decidir.sdk.resources;

import com.decidir.sdk.dto.tokens.Token;
import com.decidir.sdk.dto.tokens.TokenResponse;
import com.decidir.sdk.dto.tokens.TokenCs;

import retrofit2.Call;
import retrofit2.http.*;

public interface TokenApi {
	
	@POST("token")
	Call <TokenResponse> token (@Body Token tokenReq);
	
	@POST("token")
	Call <TokenResponse> tokenCS(@Body TokenCs toquenCsReq);
}
