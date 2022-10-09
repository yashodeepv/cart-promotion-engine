package com.yasho;

import com.yasho.domain.Promotion;
import com.yasho.domain.ShoppingCart;

import java.util.List;

public class PromotionEngine {
    private ShoppingCart cart;
    private List<Promotion> promotions;
    public PromotionEngine(ShoppingCart cart, List<Promotion> promotions) {
        this.cart = cart;
        this.promotions = promotions;
    }


}
