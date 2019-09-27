package com.decidir.sdk.dto.cybersource;

import java.io.Serializable;

public class Account implements Serializable {

    private String id;
    private String name;
    private Integer category;
    private Integer antiquity;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getAntiquity() {
        return antiquity;
    }

    public void setAntiquity(Integer antiquity) {
        this.antiquity = antiquity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
