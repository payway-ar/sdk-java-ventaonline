/**
 * 
 */
package com.decidir.sdk.dto.payments.threeds;

import com.decidir.sdk.dto.payments.PaymentResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author fquispe
 *
 */
@JsonInclude(Include.NON_NULL)
public class PaymentAuth3dsResponse extends PaymentResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long timeout;
	private TargetThreeds target;
	private HttpThreeds http;
	
	public Long getTimeout() {
		return timeout;
	}
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}
	public TargetThreeds getTarget() {
		return target;
	}
	public void setTarget(TargetThreeds target) {
		this.target = target;
	}
	public HttpThreeds getHttp() {
		return http;
	}
	public void setHttp(HttpThreeds http) {
		this.http = http;
	}
	
	
}
