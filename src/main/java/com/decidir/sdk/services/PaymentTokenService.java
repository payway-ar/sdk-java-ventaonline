package com.decidir.sdk.services;


import java.io.IOException;

import com.decidir.sdk.converters.ErrorConverter;
import com.decidir.sdk.converters.PaymentConverter;
import com.decidir.sdk.converters.PaymentTokenConverter;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.tokens.PaymentToken;
import com.decidir.sdk.dto.tokens.PaymentTokenCS;
import com.decidir.sdk.exceptions.DecidirException;
import com.decidir.sdk.resources.PaymentApi;
import com.decidir.sdk.resources.PaymentTokenApi;
import com.decidir.sdk.resources.PaymentTokenResponse;

import retrofit2.Response;

public class PaymentTokenService {
	
	public static final int HTTP_500 = 500;
    public static final int HTTP_402 = 402;
    private PaymentTokenApi paymentTokenApi;
    private PaymentTokenConverter paymentTokenConverter;
    private ErrorConverter errorConverter;
    
    private PaymentTokenService(PaymentTokenApi paymentTokenApi, PaymentTokenConverter paymentTokenConverter, ErrorConverter errorConverter) {
    	this.paymentTokenApi = paymentTokenApi;
    	this.paymentTokenConverter = paymentTokenConverter;
    	this.errorConverter = errorConverter;
    }
    
    public static PaymentTokenService getInstance(PaymentTokenApi paymentTokenApi) {
		return new PaymentTokenService(paymentTokenApi, new PaymentTokenConverter(), new ErrorConverter());
	}
    
    public DecidirResponse<PaymentTokenResponse> token(PaymentToken token){
    	try {
			Response<PaymentTokenResponse> response = this.paymentTokenApi.token(token).execute();
			return paymentTokenConverter.convert(response, response.body());
    	} catch (IOException ioe) {
    		throw new DecidirException(HTTP_500, ioe.getMessage());
		}
    }
    
    public DecidirResponse<PaymentTokenResponse> tokenCS(PaymentTokenCS token){
    	try {
			Response<PaymentTokenResponse> response = this.paymentTokenApi.token(token).execute();
			return paymentTokenConverter.convert(response, response.body());
    	} catch (IOException ioe) {
    		throw new DecidirException(HTTP_500, ioe.getMessage());
		}
    }
    
}
