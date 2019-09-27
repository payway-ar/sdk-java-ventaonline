package com.decidir.sdk.resources;

import com.decidir.sdk.dto.annullment.AnnulRefundResponse;
import com.decidir.sdk.dto.refunds.*;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by biandra on 22/09/16.
 */
public interface RefundApi {

    @GET("payments/{paymentId}/refunds")
    Call<RefundPaymentHistoryResponse> getRefunds(@Path("paymentId") Long paymentId);

    @POST("payments/{paymentId}/refunds")
    Call<RefundPaymentResponse> refundPayment(@Header("User") String user,@Path("paymentId") Long paymentId, @Body RefundPayment refundPayment);

    @POST("payments/{paymentId}/refunds")
    Call<RefundPaymentResponse> refundMPOSPayment(@Header("User") String user, @Path("paymentId") Long paymentId, @Body RefundMPOSPayment refundPayment);

    @DELETE("payments/{paymentId}/refunds/{refundId}")
    Call<AnnulRefundResponse> cancelRefund(@Header("User") String user, @Path("paymentId") Long paymentId, @Path("refundId") Long refundId);

    @DELETE("payments/{paymentId}/refunds/{refundId}")
    Call<AnnulRefundResponse> cancelMPOSRefund(@Header("User") String user, @Path("paymentId") Long paymentId, @Path("refundId") Long refundId, @Body RollbackMPOSPayment rollbackMPOSPayment);

}
