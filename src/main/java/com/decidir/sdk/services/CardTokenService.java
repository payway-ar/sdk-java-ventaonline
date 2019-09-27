package com.decidir.sdk.services;

import com.decidir.sdk.converters.CardTokenConverter;
import com.decidir.sdk.converters.ErrorConverter;
import com.decidir.sdk.dto.tokens.CardTokens;
import com.decidir.sdk.exceptions.DecidirError;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.exceptions.DecidirException;
import com.decidir.sdk.resources.CardTokenApi;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by biandra on 22/09/16.
 */
public class CardTokenService {

    public static final int HTTP_500 = 500;
    public static final int HTTP_402 = 402;
    private CardTokenApi cardTokenApi;
    private CardTokenConverter cardTokenConverter;
    private ErrorConverter errorConverter;

    private CardTokenService(CardTokenApi cardTokenApi, CardTokenConverter cardTokenConverter, ErrorConverter errorConverter){
        this.cardTokenApi = cardTokenApi;
        this.cardTokenConverter = cardTokenConverter;
        this.errorConverter = errorConverter;
    }

    public static CardTokenService getInstance(CardTokenApi cardTokenApi) {
        return new CardTokenService(cardTokenApi, new CardTokenConverter(), new ErrorConverter());
    }

    public DecidirResponse<CardTokens> getCardTokens(String userSiteId, String bin, String lastFourDigits, String expirationMonth, String expirationYear) {
        try {
            Response<CardTokens> response = this.cardTokenApi.getCardTokens(userSiteId, bin, lastFourDigits, expirationMonth, expirationYear).execute();
            if (response.isSuccessful()) {
                return cardTokenConverter.convert(response, response.body());
            } else {
                DecidirResponse<DecidirError> error = errorConverter.convert(response);
                throw DecidirException.wrap(error.getStatus(), error.getMessage(), error.getResult());
            }
        } catch(IOException ioe) {
            throw new DecidirException(HTTP_500, ioe.getMessage());
        }
    }

    public DecidirResponse<Void> deleteCardToken(String token) {
        try {
            Response<Void> response = this.cardTokenApi.deleteCardToken(token).execute();
            if (response.isSuccessful()) {
                return cardTokenConverter.convert(response);
            } else {
                DecidirResponse<DecidirError> error = errorConverter.convert(response);
                throw DecidirException.wrap(error.getStatus(), error.getMessage(), error.getResult());
            }
        } catch(IOException ioe) {
            throw new DecidirException(HTTP_500, ioe.getMessage());
        }
    }
}
