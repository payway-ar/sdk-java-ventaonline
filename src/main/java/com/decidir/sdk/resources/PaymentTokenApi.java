package com.decidir.sdk.resources;

import com.decidir.sdk.dto.tokens.PaymentToken;
import com.decidir.sdk.dto.tokens.PaymentTokenCS;

import retrofit2.Call;
import retrofit2.http.*;

public interface PaymentTokenApi {
	
	@POST("token")
	Call <PaymentTokenResponse> token (@Body PaymentToken tokenReq);
	
	@POST("token")
	Call <PaymentTokenResponse> tokenCS(@Body PaymentTokenCS toquenCsReq);
}
