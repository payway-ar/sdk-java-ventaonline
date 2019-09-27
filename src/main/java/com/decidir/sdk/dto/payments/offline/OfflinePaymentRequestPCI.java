package com.decidir.sdk.dto.payments.offline;

/**
 * DTO Offline Payment PCI used to communicate with Decidir's Payment Service
 * <br>
 * <br>
 * <strong>Usage example</strong>
 * <pre>
 * {@code ...
 * OfflinePaymentRequestPCI offlinePaymentRequestPCI = new OfflinePaymentRequestPCI();
 * offlinePaymentRequestPCI.setSite_transaction_id("0001234");
 * offlinePaymentRequestPCI.setPayment_method_id(15); //mastercard
 * offlinePaymentRequestPCI.setAmount(23250L);//Amount in cents: $232.50
 * offlinePaymentRequestPCI.setCurrency(Currency.ARS);
 * offlinePaofflinePaymentRequestPCIymentRequest.setCod_p1("123")
 * //common offline payment data - i.e. see {@link OfflinePayment}
 * ...
 * }
 * </pre>
 */

public class OfflinePaymentRequestPCI extends OfflinePaymentRequest {
    OfflineCustomer customer;

    public OfflinePaymentRequestPCI() {
        this.setPayment_mode("offline");
    }

    public OfflineCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(OfflineCustomer customer) {
        this.customer = customer;
    }
}
