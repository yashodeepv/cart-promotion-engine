package com.yasho.domain;

import java.util.Optional;

public class SingleProductComboOffer implements Promotion {
    private Product product;
    private int offerQuantity;
    private int offerCost;

    public SingleProductComboOffer(Product product, int offerQuantity, int offerCost) {
        this.product = product;
        this.offerCost = offerCost;
        this.offerQuantity = offerQuantity;
    }

    @Override
    public int getTotal(ShoppingCart cart, CartItem cartItem) {
        if(!product.equals(cartItem.getProduct())) {
            return -1;
        }
        Optional<CartItem> first = cart.getItems().stream().filter(cartItem::equals).findFirst();

        if(first.isPresent()) {
            int q = first.get().getQuantity();
            int offerMultiplier = 0;
            while(q >= offerQuantity) {
                q -= offerQuantity;
                offerMultiplier++;
            }
            if(q < 0) {
                return -1;
            }
            return offerCost*offerMultiplier + q * product.getCost();
        }
        return -1;
    }


}
