package com.decidir.sdk.exceptions.responses;

import java.io.Serializable;

public interface ResponseException<R extends Serializable> {
    int getStatus();
    R getResponse();
}
