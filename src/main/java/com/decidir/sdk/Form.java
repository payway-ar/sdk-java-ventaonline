package com.decidir.sdk;

import com.decidir.sdk.configuration.DecidirConfiguration;
import com.decidir.sdk.dto.forms.DataForm;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.forms.FormResponse;
import com.decidir.sdk.exceptions.DecidirException;
import com.decidir.sdk.resources.FormApi;
import com.decidir.sdk.services.FormService;

/**
 * Created by biandra on 20/06/17.
 */
public class Form {

    private static String apiUrl = "https://live.decidir.com/web/";
    private static Integer timeOut = 5;
    private FormService formService;

    /**
     *
     * Creates a new instance to communicate with Form Api.
     * @param secretAccessToken the provided apikey
     * @param apiUrl Decidir Api URL. If URL is not provided, <em><strong>https://live.decidir.com/api/v1</strong></em> will be used
     * @param timeOut sets the request timeout expressed in seconds, by default sets <strong>5 seconds</strong> if no value is provided. <strong>Must</strong> be greater than 0 (zero)
     * @throws IllegalArgumentException if an invalid timeout value is used
     * 
     */
    public Form(final String secretAccessToken, final String apiUrl, final Integer timeOut) {
        if (apiUrl != null) {
            this.apiUrl = apiUrl;
        }
        if (timeOut != null) {
            this.timeOut = timeOut;
        }
        this.formService = FormService.getInstance(
                DecidirConfiguration.initRetrofit(secretAccessToken, this.apiUrl, this.timeOut, FormApi.class));
    }

    public Form(final String secretAccessToken) {
        this(secretAccessToken, null, null);
    }

    public Form(final String secretAccessToken, final Integer timeOut) {
        this(secretAccessToken, null, timeOut);
    }


    /**
     * Generate hash of data form
     * @param form
     * @return a {@link DecidirResponse} when success
     * @throws DecidirException when an error occurs
     */
    public DecidirResponse<FormResponse> validate(DataForm form) throws DecidirException {
        return formService.validate(form);
    }
}
