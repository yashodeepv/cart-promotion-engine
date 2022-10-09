package com.yasho.domain;

import java.util.Map;

public class ComboOfferPromotion implements Promotion {
    Map<Product, Integer> productMap;
    int cost;
    public ComboOfferPromotion(Map<Product, Integer> productMap, int cost) {
        this.productMap = productMap;
        this.cost = cost;
    }

    @Override
    public int apply() {
        return cost;
    }
}
