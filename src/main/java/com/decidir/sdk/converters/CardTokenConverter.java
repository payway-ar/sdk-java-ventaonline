package com.decidir.sdk.converters;

import com.decidir.sdk.dto.tokens.CardTokens;
import com.decidir.sdk.dto.DecidirResponse;
import retrofit2.Response;

/**
 * Created by biandra on 22/09/16.
 */
public class CardTokenConverter extends DecidirConverter {

    public DecidirResponse<CardTokens> convert(Response<CardTokens> response, CardTokens cardTokens) {
        DecidirResponse<CardTokens> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setResult(cardTokens);
        dResponse.setMessage(response.message());
        return dResponse;
    }

    public DecidirResponse<Void> convert(Response<Void> response) {
        DecidirResponse<Void> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setMessage(response.message());
        return dResponse;
    }
}
