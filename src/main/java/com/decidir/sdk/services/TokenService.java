package com.decidir.sdk.services;

import java.io.IOException;

import com.decidir.sdk.converters.ErrorConverter;
import com.decidir.sdk.converters.TokenConverter;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.tokens.Token;
import com.decidir.sdk.dto.tokens.TokenResponse;
import com.decidir.sdk.dto.tokens.TokenCs;
import com.decidir.sdk.exceptions.DecidirError;
import com.decidir.sdk.exceptions.DecidirException;
import com.decidir.sdk.resources.TokenApi;
import retrofit2.Response;

public class TokenService {

	public static final int HTTP_500 = 500;
	public static final int HTTP_402 = 402;
	private TokenApi tokenApi;
	private TokenConverter tokenConverter;
	private ErrorConverter errorConverter;

	private TokenService(TokenApi tokenApi, TokenConverter tokenConverter, ErrorConverter errorConverter) {
		this.tokenApi = tokenApi;
		this.tokenConverter = tokenConverter;
		this.errorConverter = errorConverter;
	}

	public static TokenService getInstance(TokenApi tokenApi) {
		return new TokenService(tokenApi, new TokenConverter(), new ErrorConverter());
	}

	public DecidirResponse<TokenResponse> token(Token token) {
		try {
			Response<TokenResponse> response = this.tokenApi.token(token).execute();
			if (response.isSuccessful()) {
				return tokenConverter.convert(response, response.body());
			}

			DecidirResponse<DecidirError> error = errorConverter.convert(response);
			throw DecidirException.wrap(error.getStatus(), error.getMessage(), error.getResult());
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

	public DecidirResponse<TokenResponse> tokenCS(TokenCs token) {
		try {
			Response<TokenResponse> response = this.tokenApi.token(token).execute();
			if (response.isSuccessful()) {
				return tokenConverter.convert(response, response.body());
			}

			DecidirResponse<DecidirError> error = errorConverter.convert(response);
			throw DecidirException.wrap(error.getStatus(), error.getMessage(), error.getResult());
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}

}