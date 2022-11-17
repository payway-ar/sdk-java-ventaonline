/**
 * 
 */
package com.decidir.sdk.converters;

import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.auth3ds.Auth3dsResponse;

import retrofit2.Response;

/**
 * @author fquispe
 *
 */
public class Instruction3dsConverter extends DecidirConverter {
	
	public DecidirResponse<Auth3dsResponse> convert(Response<Auth3dsResponse> response, Auth3dsResponse instruction3dsResponse) {
        DecidirResponse<Auth3dsResponse> dResponse = new DecidirResponse<Auth3dsResponse>();
        dResponse.setStatus(response.code());
        dResponse.setResult(instruction3dsResponse);
        dResponse.setMessage(response.message());
        return dResponse;
    }
}
