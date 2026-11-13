package com.decidir.sdk.dto.checkout.history;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class HistoryResponse {

    private List<ButtonDto> history;
    private Long count;
    private Integer page;
    private Long totalItems;

    public List<ButtonDto> getHistory() {
        return history;
    }

    public void setHistory(List<ButtonDto> history) {
        this.history = history;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    @Override
    public String toString() {
        return "HistoryResponse{" +
                "history=" + history +
                ", count=" + count +
                ", page=" + page +
                ", totalItems=" + totalItems +
                '}';
    }
}
