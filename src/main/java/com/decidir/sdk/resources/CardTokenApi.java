package com.decidir.sdk.resources;

import com.decidir.sdk.dto.tokens.CardTokens;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by biandra on 22/09/16.
 */
public interface CardTokenApi {

    @GET("usersite/{userSiteId}/cardtokens")
    Call<CardTokens> getCardTokens(@Path("userSiteId") String userSiteId,
                             @Query("lastFourDigits") String bin ,
                             @Query("lastFourDigits") String lastFourDigits,
                             @Query("expirationMonth") String expirationMonth,
                             @Query("expirationYear") String expirationYear);

    @DELETE("cardtokens/{cardtokenId}")
    Call<Void> deleteCardToken(@Path("cardtokenId") String token);
}
