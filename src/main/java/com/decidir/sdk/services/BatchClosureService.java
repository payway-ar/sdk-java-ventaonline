package com.decidir.sdk.services;

import java.io.IOException;

import com.decidir.sdk.converters.BatchClosureConverter;
import com.decidir.sdk.converters.ErrorConverter;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.batchClosure.BatchClosure;
import com.decidir.sdk.dto.batchClosure.BatchClosureResponse;
import com.decidir.sdk.exceptions.DecidirError;
import com.decidir.sdk.exceptions.DecidirException;
import com.decidir.sdk.resources.BatchClosureApi;

import retrofit2.Response;

public class BatchClosureService {
	
	public static final int HTTP_500 = 500;
	public static final int HTTP_402 = 402;
	private BatchClosureApi batchclosureApi;
	private BatchClosureConverter batchClosureConverter;
	private ErrorConverter errorConverter;
	
	private BatchClosureService(BatchClosureApi batchclosureApi, BatchClosureConverter batchClosureConverter, ErrorConverter errorConverter) {
		this.batchclosureApi = batchclosureApi;
		this.batchClosureConverter = batchClosureConverter;
		this.errorConverter = errorConverter;
	}
	
	public static BatchClosureService getInstance(BatchClosureApi batchClosureApi) {
		return new BatchClosureService(batchClosureApi, new BatchClosureConverter(), new ErrorConverter());
	}
	
	public DecidirResponse<BatchClosureResponse> batchClosure(BatchClosure batchClosure){
		try {
			Response<BatchClosureResponse> response = this.batchclosureApi.batchClosure(batchClosure).execute();
			if (response.isSuccessful()) {
				return batchClosureConverter.convert(response, response.body());
			}
			
			DecidirResponse<DecidirError> error = errorConverter.convert(response);
			throw DecidirException.wrap(error.getStatus(), error.getMessage(), error.getResult());
		
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
	}
}
