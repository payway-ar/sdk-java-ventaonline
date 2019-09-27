package com.decidir.sdk.dto.forms;

import java.io.Serializable;

/**
 * Created by biandra on 19/06/17.
 */
public class FormResponse implements Serializable {

    private String hash;

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
