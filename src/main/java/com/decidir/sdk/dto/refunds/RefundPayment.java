package com.decidir.sdk.dto.refunds;

import java.io.Serializable;
import java.util.List;

import com.decidir.sdk.dto.payments.pci.CardTrackInfo;

/**
 * Created by biandra on 05/10/16.
 */
public class RefundPayment implements Serializable {

    private Long amount;
    private List<RefundSubPayment> sub_payments;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public List<RefundSubPayment> getSub_payments() {
        return sub_payments;
    }

    public void setSub_payments(List<RefundSubPayment> sub_payments) {
        this.sub_payments = sub_payments;
    }

}
