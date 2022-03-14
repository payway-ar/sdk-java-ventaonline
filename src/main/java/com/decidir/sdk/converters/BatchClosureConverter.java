package com.decidir.sdk.converters;

import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.batchClosure.BatchClosureResponse;

import retrofit2.Response;

public class BatchClosureConverter extends DecidirConverter{
	
	public DecidirResponse<BatchClosureResponse> convert(Response<BatchClosureResponse> response, BatchClosureResponse batchClosure){
		DecidirResponse<BatchClosureResponse> dResponse = new DecidirResponse();
		dResponse.setStatus(response.code());
        dResponse.setResult(batchClosure);
        dResponse.setMessage(response.message());
        return dResponse;
	}

}
