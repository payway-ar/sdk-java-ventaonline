package com.decidir.sdk.converters;

import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.forms.FormResponse;
import retrofit2.Response;

/**
 * Created by biandra on 19/06/17.
 */
public class FormConverter extends DecidirConverter {

    public DecidirResponse<FormResponse> convert(Response<FormResponse> response, FormResponse formResponse){
        DecidirResponse<FormResponse> dResponse = new DecidirResponse();
        dResponse.setStatus(response.code());
        dResponse.setResult(formResponse);
        dResponse.setMessage(response.message());
        return dResponse;
    }
}
