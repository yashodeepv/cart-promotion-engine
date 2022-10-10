package com.yasho;

import com.yasho.domain.CartItem;
import com.yasho.domain.Promotion;
import com.yasho.domain.ShoppingCart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PromotionEngine {

    public int calculateTotalValue(ShoppingCart cart, List<Promotion> promotions) {
        int total = 0;
        Set<CartItem> visited = new HashSet<>();
        for(Promotion promotion : promotions) {
            for(CartItem cartItem : cart.getItems()) {
                int total1 = promotion.getTotal(cart, cartItem);
                if(total1 != -1) {
                    total += total1;
                    visited.add(cartItem);
                }
            }
        }
        for(CartItem cartItem : cart.getItems()) {
            if(!visited.contains(cartItem)) {
                total += (cartItem.getProduct().getCost() * cartItem.getQuantity());
            }
        }
        return total;
    }
}
