package com.decidir.sdk.dto.payments.pci;

import java.io.Serializable;

/**
 * Created by gustavo on 7/26/17.
 */
public class CardTrackInfo implements Serializable {

    private String card_track_1;
    private String card_track_2;
    private String input_mode;

    public String getCard_track_1() {
        return card_track_1;
    }

    public void setCard_track_1(String card_track_1) {
        this.card_track_1 = card_track_1;
    }

    public String getCard_track_2() {
        return card_track_2;
    }

    public void setCard_track_2(String card_track_2) {
        this.card_track_2 = card_track_2;
    }

    public String getInput_mode() {
        return input_mode;
    }

    public void setInput_mode(String input_mode) {
        this.input_mode = input_mode;
    }
}
