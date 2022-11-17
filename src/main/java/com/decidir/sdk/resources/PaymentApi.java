package com.decidir.sdk.resources;

import com.decidir.sdk.dto.confirms.ConfirmPaymentAmount;
import com.decidir.sdk.dto.instruction3ds.Instruction3dsData;
import com.decidir.sdk.dto.payments.Page;
import com.decidir.sdk.dto.payments.PaymentRequest;
import com.decidir.sdk.dto.payments.PaymentResponse;
import com.decidir.sdk.dto.payments.agro.AgroPaymentRequestNoPCI;
import com.decidir.sdk.dto.payments.agro.AgroPaymentResponse;
import com.decidir.sdk.dto.payments.bsa.BSAPaymentRequestPCI;
import com.decidir.sdk.dto.payments.bsa.BSAPaymentResponse;
import com.decidir.sdk.dto.payments.gds.GDSPaymentRequestNoPCI;
import com.decidir.sdk.dto.payments.gds.GDSPaymentRequestPCI;
import com.decidir.sdk.dto.payments.gds.GDSPaymentResponse;
import com.decidir.sdk.dto.payments.offline.OfflinePaymentRequest;
import com.decidir.sdk.dto.payments.offline.OfflinePaymentRequestPCI;
import com.decidir.sdk.dto.payments.offline.OfflinePaymentResponse;
import com.decidir.sdk.dto.payments.pci.PaymentPciRequest;
import com.decidir.sdk.dto.payments.pci.PaymentPciTokenRequest;
import com.decidir.sdk.dto.payments.threeds.PaymentAuth3dsResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
  Call<PaymentAuth3dsResponse> payThreeds(@Body PaymentRequest payment);
  
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
  
  @POST("threeds/instruction")
  Call<PaymentAuth3dsResponse> sendInstructionThreeDS(@Header("X-Consumer-Username") String xConsumer, @Body Instruction3dsData instruction3dsData); 

}
