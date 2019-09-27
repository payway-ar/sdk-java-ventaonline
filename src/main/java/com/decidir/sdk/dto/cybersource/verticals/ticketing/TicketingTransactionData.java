package com.decidir.sdk.dto.cybersource.verticals.ticketing;

import com.decidir.sdk.dto.cybersource.Item;

import java.io.Serializable;
import java.util.List;

/**
 * Created by biandra on 21/06/16.
 */
public class TicketingTransactionData implements Serializable{

    private Integer days_to_event;
    private String delivery_type;
    private List<Item> items;

    public Integer getDays_to_event() {
        return days_to_event;
    }

    public void setDays_to_event(Integer days_to_event) {
        this.days_to_event = days_to_event;
    }

    public String getDelivery_type() {
        return delivery_type;
    }

    public void setDelivery_type(String delivery_type) {
        this.delivery_type = delivery_type;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
