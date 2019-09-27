package com.decidir.sdk.dto.cybersource.verticals.digitalgoods;

import com.decidir.sdk.dto.cybersource.Item;

import java.io.Serializable;
import java.util.List;

/**
 * Created by biandra on 21/06/16.
 */
public class DigitalGoodsTransactionData implements Serializable{

    private String delivery_type;
    private List<Item> items;

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
