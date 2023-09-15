package com.decidir.sdk.converters;

import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.internaltoken.InternalTokenPaymentResponse;
import com.decidir.sdk.dto.internaltoken.InternalTokenResponse;
import com.decidir.sdk.exceptions.DecidirError;
import com.decidir.sdk.exceptions.InternalTokenError;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;

public class InternalTokenConverter extends DecidirConverter {
    public DecidirResponse<InternalTokenResponse> convert(Response<InternalTokenResponse> response, InternalTokenResponse token) {
        DecidirResponse<InternalTokenResponse> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setResult(token);
        dResponse.setMessage(response.message());
        return dResponse;
    }


    public DecidirResponse<InternalTokenPaymentResponse> convert(Response<InternalTokenPaymentResponse> response, InternalTokenPaymentResponse token) {
        DecidirResponse<InternalTokenPaymentResponse> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setResult(token);
        dResponse.setMessage(response.message());
        return dResponse;
    }

    public DecidirResponse<InternalTokenError> convert(Response response) throws IOException {
        DecidirResponse<InternalTokenError> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setResult(super.convert(response.errorBody().bytes(), InternalTokenError.class));
        dResponse.setMessage(response.message());
        return dResponse;
    }
}
