package com.decidir.sdk.dto.tokens;

import java.io.Serializable;
import java.util.List;

/**
 * Created by biandra on 22/09/16.
 */
public class CardTokens implements Serializable {

    private List<CardToken> tokens;

    public List<CardToken> getTokens() {
        return tokens;
    }

    public void setTokens(List<CardToken> tokens) {
        this.tokens = tokens;
    }
}
