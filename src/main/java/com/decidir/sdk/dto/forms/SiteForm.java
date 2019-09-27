package com.decidir.sdk.dto.forms;

import java.io.Serializable;

/**
 * Created by biandra on 19/06/17.
 */
public class SiteForm implements Serializable {

    private String id;
    private String transaction_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
}
