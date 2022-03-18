package com.decidir.sdk.resources;

import com.decidir.sdk.dto.batchClosure.BatchClosure;
import com.decidir.sdk.dto.batchClosure.BatchClosureResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BatchClosureApi {
	
	@POST("closures/batchclosure")
	Call<BatchClosureResponse> batchClosure(@Body BatchClosure batchClosureReq);
}
