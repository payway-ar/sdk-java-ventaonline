package com.decidir.sdk.resources;

import com.decidir.sdk.dto.checkout.CheckoutResponse;
import com.decidir.sdk.dto.checkout.CheckoutRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CheckoutApi {
	
	@POST("/link")
	Call <CheckoutResponse> checkoutHash (@Body CheckoutRequest checkoutReq);

}
