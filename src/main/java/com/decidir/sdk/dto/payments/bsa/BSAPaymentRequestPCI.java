package com.decidir.sdk.dto.payments.bsa;

import com.decidir.sdk.dto.payments.Identification;
import com.decidir.sdk.payments.Payment;

public class BSAPaymentRequestPCI extends Payment{

    Identification card_holder_identification;
    CardTokenBsa card_token_bsa;

    public BSAPaymentRequestPCI() {
        this.setPayment_mode("bsa");
    }

    public Identification getCard_holder_identification() {
        return card_holder_identification;
    }

    public void setCard_holder_identification(Identification card_holder_identification) {
        this.card_holder_identification = card_holder_identification;
    }

    public CardTokenBsa getCard_token_bsa() {
        return card_token_bsa;
    }

    public void setCard_token_bsa(CardTokenBsa card_token_bsa) {
        this.card_token_bsa = card_token_bsa;
    }
}
