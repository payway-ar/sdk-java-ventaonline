package com.decidir.sdk.converters;

import com.decidir.sdk.exceptions.DecidirError;
import com.decidir.sdk.dto.DecidirResponse;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by biandra on 04/08/16.
 */
public class ErrorConverter extends DecidirConverter {

    public DecidirResponse<DecidirError> convert(Response response) throws IOException {
        DecidirResponse<DecidirError> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setResult(super.convert(response.errorBody().bytes(), DecidirError.class));
        dResponse.setMessage(response.message());
        return dResponse;
    }
}
