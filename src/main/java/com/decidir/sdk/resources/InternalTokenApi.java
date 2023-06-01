package com.decidir.sdk.resources;

import com.decidir.sdk.dto.internaltoken.InternalTokenPaymentResponse;
import com.decidir.sdk.dto.internaltoken.InternalTokenRequest;
import com.decidir.sdk.dto.internaltoken.InternalTokenResponse;
import com.decidir.sdk.dto.internaltoken.InternalTokenPaymentRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface InternalTokenApi {
    @POST("tokens")
    Call<InternalTokenResponse> token(@Body InternalTokenRequest token);

    @POST("payments")
    Call<InternalTokenPaymentResponse> payment(@Body InternalTokenPaymentRequest request);
}
