package com.decidir.sdk.dto;

import java.io.Serializable;

/**
 * Created by biandra on 07/09/17.
 */
public class CardErrorReason implements Serializable{

    private Integer id;
    private String description;
    private String additional_description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdditional_description() {
        return additional_description;
    }

    public void setAdditional_description(String additional_description) {
        this.additional_description = additional_description;
    }
}
