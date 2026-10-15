package com.decidir.sdk.resources;

import com.decidir.sdk.dto.checkout.CheckoutResponse;
import com.decidir.sdk.dto.checkout.CheckoutRequest;

import com.decidir.sdk.dto.checkout.history.HistoryResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CheckoutApi {
	
	@POST("link")
	Call <CheckoutResponse> checkoutHash (@Body CheckoutRequest checkoutReq);

	@GET("get-history")
	Call <HistoryResponse> getHistory (@Query("cuit") String cuit,
									   @Query("site_id")String siteId,
									   @Query("operation_id")String operationId,
									   @Query("status")String status,
									   @Query("from_date")String fromDate,
									   @Query("to_date")String toDate,
									   @Query("platform")String platform,
									   @Query("page")Integer page,
									   @Query("items_per_page")Integer itemsPerPage,
									   @Query("description")String description,
									   @Query("currency")String currency,
									   @Query("establishment_number")Long establishmentNumber,
									   @Query("max_amount")Double maxAmount,
									   @Query("min_amount")Double minAmount,
									   @Query("installments")Integer installments,
									   @Query("payment_method_id")Long paymentMethodId
										 );

}
