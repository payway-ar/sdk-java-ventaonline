package com.decidir.sdk.services;

import com.decidir.sdk.converters.ErrorConverter;
import com.decidir.sdk.converters.FormConverter;
import com.decidir.sdk.dto.forms.DataForm;
import com.decidir.sdk.exceptions.DecidirError;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.forms.FormResponse;
import com.decidir.sdk.exceptions.DecidirException;
import com.decidir.sdk.resources.FormApi;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by biandra on 19/06/17.
 */
public class FormService {

    public static final int HTTP_500 = 500;
    public static final int HTTP_402 = 402;
    private ErrorConverter errorConverter;
    private FormApi formApi;
    private FormConverter formConverter;

    private FormService(FormApi formApi, FormConverter formConverter, ErrorConverter errorConverter){
        this.formApi = formApi;
        this.formConverter = formConverter;
        this.errorConverter = errorConverter;
    }

    public static FormService getInstance(FormApi formApi) {
        return new FormService(formApi, new FormConverter(), new ErrorConverter());
    }

    public DecidirResponse<FormResponse> validate(DataForm dataForm) {
        try {
            Response<FormResponse> response = this.formApi.validate(dataForm).execute();
            if (response.isSuccessful()) {
                return formConverter.convert(response, response.body());
            } else {
                DecidirResponse<DecidirError> error = errorConverter.convert(response);
                throw DecidirException.wrap(error.getStatus(), error.getMessage(), error.getResult());
            }
        } catch(IOException ioe) {
            throw new DecidirException(HTTP_500, ioe.getMessage());
        }
    }
}
