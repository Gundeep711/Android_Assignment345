package com.application.assignment345;
import androidx.annotation.NonNull;

import java.io.Serializable;

public class Order implements Serializable {

    String order2;
    String quantity2;
    String tPrice2;

    public Order(String order, String quantity, String tPrice) {
        this.order2 = order;
        this.quantity2 = quantity;
        this.tPrice2 = tPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order='" + order2 + '\'' +
                ", quantity=" + quantity2 +
                ", tPrice=" + tPrice2 +
                '}';
    }
}