package com.decidir.sdk.resources;

import com.decidir.sdk.dto.confirms.ConfirmPaymentAmount;
import com.decidir.sdk.dto.payments.*;
import com.decidir.sdk.dto.payments.agro.AgroPaymentRequestNoPCI;
import com.decidir.sdk.dto.payments.agro.AgroPaymentResponse;
import com.decidir.sdk.dto.payments.bsa.BSAPaymentRequestPCI;
import com.decidir.sdk.dto.payments.bsa.BSAPaymentResponse;
import com.decidir.sdk.dto.payments.gds.GDSPaymentRequestNoPCI;
import com.decidir.sdk.dto.payments.offline.OfflinePaymentRequest;
import com.decidir.sdk.dto.payments.offline.OfflinePaymentRequestPCI;
import com.decidir.sdk.dto.payments.offline.OfflinePaymentResponse;
import com.decidir.sdk.dto.payments.pci.PaymentPciRequest;
import com.decidir.sdk.dto.payments.pci.PaymentPciTokenRequest;
import com.decidir.sdk.dto.payments.gds.GDSPaymentRequestPCI;
import com.decidir.sdk.dto.payments.gds.GDSPaymentResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface PaymentApi {

  @GET("payments")
  Call<Page> getPayments(@Query("offset") Integer offset,
                         @Query("pageSize") Integer pageSize,
                         @Query("siteOperationId") String siteOperationId,
                         @Query("siteId") String merchantId);

  @GET("payments/{paymentId}?expand=card_data")
  Call<PaymentResponse> getPayment(@Path("paymentId") Long id);

  @POST("payments")
  Call<PaymentResponse> payNoPci(@Body PaymentRequest payment);
  
  @POST("payments")
  Call<PaymentResponse> payPciCard(@Body PaymentPciRequest payment);
  
  @POST("payments")
  Call<PaymentResponse> payPciToken(@Body PaymentPciTokenRequest payment);

  @POST("payments")
  Call<OfflinePaymentResponse> payOffline(@Body OfflinePaymentRequest offlinePayment);

  @POST("payments")
  Call<OfflinePaymentResponse> payOfflinePCI(@Body OfflinePaymentRequestPCI offlinePCIPayment);

  @POST("payments")
  Call<GDSPaymentResponse> payGdsNoPci(@Body GDSPaymentRequestNoPCI gdsPayment);

  @POST("payments")
  Call<GDSPaymentResponse> payGdsPci(@Body GDSPaymentRequestPCI gdsPayment);

  @POST("payments")
  Call<BSAPaymentResponse> payBsaPci(@Body BSAPaymentRequestPCI bsaPaymentRequestPCI);

  @POST("payments")
  Call<AgroPaymentResponse> payAgroNoPci(@Body AgroPaymentRequestNoPCI agroPaymentRequestNoPCI);

  @PUT("payments/{paymentId}")
  Call<PaymentResponse> paymentConfirm(@Header("User") String user, @Path("paymentId") Long id, @Body ConfirmPaymentAmount confirmPayment);

}
