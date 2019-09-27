package com.decidir.sdk.services;

import java.io.IOException;

import com.decidir.sdk.converters.PaymentConverter;
import com.decidir.sdk.dto.DecidirResponse;
import com.decidir.sdk.dto.annullment.AnnulRefundResponse;
import com.decidir.sdk.dto.refunds.*;
import com.decidir.sdk.exceptions.DecidirError;
import com.decidir.sdk.exceptions.DecidirException;
import com.decidir.sdk.exceptions.responses.AnnulRefundException;
import com.decidir.sdk.exceptions.responses.RefundException;
import com.decidir.sdk.resources.RefundApi;

import retrofit2.Response;

/**
 * Created by biandra on 22/09/16.
 */
public class RefundsService {

    public static final int HTTP_500 = 500;
    private RefundApi refundApi;
    private PaymentConverter paymentConverter;

    private RefundsService(RefundApi refundApi, PaymentConverter paymentConverter){
        this.refundApi = refundApi;
        this.paymentConverter = paymentConverter;
    }

    public static RefundsService getInstance(RefundApi refundApi) {
        return new RefundsService(refundApi, new PaymentConverter());
    }

    public DecidirResponse<RefundPaymentHistoryResponse> getRefunds(Long paymentId) {
        try {
            Response<RefundPaymentHistoryResponse> response = this.refundApi.getRefunds(paymentId).execute();

            return this.paymentConverter.convertOrThrowSpecError(response, RefundException.class, DecidirError.class);
        } catch(IOException ioe) {
            throw new DecidirException(HTTP_500, ioe.getMessage());
        }
    }

    public DecidirResponse<RefundPaymentResponse> refundPayment(Long paymentId, RefundPayment refundPayment, String user) {
        try {
            Response<RefundPaymentResponse> response = this.refundApi.refundPayment(user, paymentId, refundPayment).execute();

            return this.paymentConverter.convertOrThrowSpecError(response, RefundException.class, RefundPaymentResponse.class);
        } catch(IOException ioe) {
            throw new DecidirException(HTTP_500, ioe.getMessage());
        }
    }

    public DecidirResponse<RefundPaymentResponse> refundMPOSPayment(Long paymentId, RefundMPOSPayment refundPayment, String user) {
        try {
            Response<RefundPaymentResponse> response = this.refundApi.refundMPOSPayment(user, paymentId, refundPayment).execute();

            return this.paymentConverter.convertOrThrowSpecError(response, RefundException.class, RefundPaymentResponse.class);
        } catch(IOException ioe) {
            throw new DecidirException(HTTP_500, ioe.getMessage());
        }
    }

	public DecidirResponse<AnnulRefundResponse> cancelRefund(Long paymentId, Long refundId, String user) {
		DecidirResponse<AnnulRefundResponse> result = null;
		try {
			Response<AnnulRefundResponse> response = this.refundApi.cancelRefund(user, paymentId, refundId).execute();

			result = this.paymentConverter.convertOrThrowSpecError(response, AnnulRefundException.class, AnnulRefundResponse.class);
		} catch (IOException ioe) {
			throw new DecidirException(HTTP_500, ioe.getMessage());
		}
		return result;
	}

    public DecidirResponse<AnnulRefundResponse> cancelMPOSRefund(Long paymentId, Long refundId, RollbackMPOSPayment rollbackMPOSPayment, String user) {
        DecidirResponse<AnnulRefundResponse> result = null;
        try {
            Response<AnnulRefundResponse> response = this.refundApi.cancelMPOSRefund(user, paymentId, refundId, rollbackMPOSPayment).execute();

            result = this.paymentConverter.convertOrThrowSpecError(response, AnnulRefundException.class, AnnulRefundResponse.class);
        } catch (IOException ioe) {
            throw new DecidirException(HTTP_500, ioe.getMessage());
        }
        return result;
    }

}
