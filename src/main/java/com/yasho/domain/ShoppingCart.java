package com.yasho.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<CartItem> items = new ArrayList<>();
    private int totalCost;
    public void addItem(CartItem cartItem) {
        items.add(cartItem);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
