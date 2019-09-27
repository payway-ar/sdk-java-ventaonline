package com.decidir.sdk.dto.refunds;

import com.decidir.sdk.dto.payments.pci.CardTrackInfo;

/**
 * Created by biandra on 11/01/18.
 */
public class RollbackMPOSPayment {

    private CardTrackInfo card_track_info;
    private String security_code;

    public CardTrackInfo getCard_track_info() {
        return card_track_info;
    }

    public void setCard_track_info(CardTrackInfo card_track_info) {
        this.card_track_info = card_track_info;
    }


    public String getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(String security_code) {
        this.security_code = security_code;
    }
}
