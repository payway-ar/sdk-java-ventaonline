package com.decidir.sdk.dto.payments;

import com.decidir.sdk.dto.payments.PaymentResponse;

import java.io.Serializable;
import java.util.ArrayList;

public final class Page implements Serializable {

  private Integer limit;
  private Integer offset;
  private ArrayList<PaymentResponse> results;
  private Boolean hasMore;

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public ArrayList<PaymentResponse> getResults() {
    return results;
  }

  public void setResults(ArrayList<PaymentResponse> results) {
    this.results = results;
  }

  public Boolean getHasMore() {
    return hasMore;
  }

  public void setHasMore(Boolean hasMore) {
    this.hasMore = hasMore;
  }
}
