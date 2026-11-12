package com.decidir.sdk.exceptions;

import java.io.Serializable;

public class CheckoutHistoryValidationError implements Serializable {

    private String code;
    private String param;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
