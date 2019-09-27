package com.decidir.sdk.dto.payments.offline;

import java.io.Serializable;

import com.decidir.sdk.dto.Status;
import com.decidir.sdk.dto.StatusDetails;

/**
 * DTO Offline Payment response used to communicate with Decidir's Payment Service
 */
public class OfflinePaymentResponse extends OfflinePayment implements Serializable {

    private String token;
    private String date;
//    private String date_created;
//    private String date_approved;
//    private String date_last_updated;
    private Status status;
    private StatusDetails status_details;
//    private ConfirmedPaymentData confirmed;
//    private String pan;
    private String barcode;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StatusDetails getStatus_details() {
        return status_details;
    }

    public void setStatus_details(StatusDetails status_details) {
        this.status_details = status_details;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
