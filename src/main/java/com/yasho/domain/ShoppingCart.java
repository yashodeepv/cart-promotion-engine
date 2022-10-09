package com.yasho.domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<CartItem> items = new ArrayList<>();
    public void addItem(CartItem cartItem) {
        items.add(cartItem);
    }

    public List<CartItem> getItems() {
        return items;
    }

}
