package com.decidir.sdk.services;

import com.decidir.sdk.converters.ErrorConverter;
import com.decidir.sdk.converters.InternalTokenConverter;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.internaltoken.InternalTokenRequest;
import com.decidir.sdk.exceptions.DecidirError;
import com.decidir.sdk.exceptions.DecidirException;
import com.decidir.sdk.resources.InternalTokenApi;
import retrofit2.Response;
import com.decidir.sdk.dto.internaltoken.InternalTokenResponse;
import com.decidir.sdk.dto.internaltoken.InternalTokenPaymentResponse;
import com.decidir.sdk.dto.internaltoken.InternalTokenPaymentRequest;

import java.io.IOException;

public class InternalTokenService {

    public static final int HTTP_500 = 500;
    public static final int HTTP_402 = 402;
    private InternalTokenApi internalTokenApi;
    private InternalTokenConverter internalTokenConverter;
    private ErrorConverter errorConverter;

    public InternalTokenService(InternalTokenApi internalTokenApi, InternalTokenConverter tokenConverter, ErrorConverter errorConverter) {
        this.internalTokenApi = internalTokenApi;
        this.internalTokenConverter = tokenConverter;
        this.errorConverter = errorConverter;
    }

    public static InternalTokenService getInstance(InternalTokenApi tokenApi) {
        return new InternalTokenService(tokenApi, new InternalTokenConverter(), new ErrorConverter());
    }

    public DecidirResponse<InternalTokenResponse> token(InternalTokenRequest token) {
        try {
            Response<InternalTokenResponse> response = this.internalTokenApi.token(token).execute();
            if (response.isSuccessful()) {
                return internalTokenConverter.convert(response, response.body());
            }
            DecidirResponse<DecidirError> error = errorConverter.convert(response);
            throw DecidirException.wrap(error.getStatus(), error.getMessage(), error.getResult());
        } catch (IOException e) {
            throw new DecidirException(HTTP_500, e.getMessage());
        }
    }

    public DecidirResponse<InternalTokenPaymentResponse> payment(InternalTokenPaymentRequest request) {
        try {
            Response<InternalTokenPaymentResponse> response = this.internalTokenApi.payment(request).execute();
            if (response.isSuccessful()) {
                return internalTokenConverter.convert(response, response.body());
            }
            DecidirResponse<DecidirError> error = errorConverter.convert(response);
            throw DecidirException.wrap(error.getStatus(), error.getMessage(), error.getResult());
        } catch (IOException e) {
            throw new DecidirException(HTTP_500, e.getMessage());
        }
    }
}
