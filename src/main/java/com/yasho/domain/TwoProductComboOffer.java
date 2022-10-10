package com.yasho.domain;

import java.util.Optional;

public class TwoProductComboOffer implements Promotion {
    private Product p1;
    private Product p2;
    private int p1Quantity;
    private int p2Quantity;
    private int cost;
    public TwoProductComboOffer(Product p1, int p1Quantity, Product p2, int p2Quantity, int cost) {
        this.p1 = p1;
        this.p1Quantity = p1Quantity;
        this.p2 = p2;
        this.p2Quantity = p2Quantity;
        this.cost = cost;
    }


    @Override
    public int getTotal(ShoppingCart shoppingCart, CartItem cartItem) {
        Optional<CartItem> cartItemP1 = shoppingCart.getItems().stream().filter(a -> p1.equals(a.getProduct())).findFirst();
        Optional<CartItem> cartItemP2 = shoppingCart.getItems().stream().filter(a -> p2.equals(a.getProduct())).findFirst();
        if(!cartItemP1.isPresent() || !cartItemP2.isPresent()) {
            return -1;
        }
        int minQ = Math.min(p1Quantity, p2Quantity);
        if(cartItem.getProduct().equals(p1)) {
            Optional<CartItem> first = shoppingCart.getItems().stream().filter(cartItem::equals).findFirst();
            int q = first.get().getQuantity();
            int mul = 0;
            int minCart = Math.min(cartItemP1.get().getQuantity(), cartItemP2.get().getQuantity());
            while(q >= minQ && mul < minCart) {
                q -= minQ;
                mul++;
            }
            if(q < 0) {
                q = 0;
            }
            return q * p1.getCost();
        }
        if(cartItem.getProduct().equals(p2)) {
            Optional<CartItem> first = shoppingCart.getItems().stream().filter(cartItem::equals).findFirst();
            int q = first.get().getQuantity();
            int mul = 0;
            int minCart = Math.min(cartItemP1.get().getQuantity(), cartItemP2.get().getQuantity());
            while(q >= minQ && mul < minCart) {
                q -= minQ;
                mul++;
            }
            if(q < 0) {
                q = 0;
            }
            return cost * mul + q * p2.getCost();
        }
        return -1;
    }
}
