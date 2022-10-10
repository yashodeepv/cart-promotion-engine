import com.yasho.PromotionEngine;
import com.yasho.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CartPromotionTest {

    PromotionEngine promotionEngine = new PromotionEngine();

    Product pA = new Product("A", 50);
    Product pB = new Product("B", 30);
    Product pC = new Product("C", 20);
    Product pD = new Product("D", 15);


    Promotion p1 = new SingleProductComboOffer(pA, 3, 130);
    Promotion p2 = new SingleProductComboOffer(pB, 2, 45);
    Promotion p3 = new TwoProductComboOffer(pC, 1, pD, 1, 30);


    @Test
    public void should_return_expected_total_value_for_scenario_1() {
        // given

        CartItem c1 = new CartItem(pA, 1);
        CartItem c2 = new CartItem(pB, 1);
        CartItem c3 = new CartItem(pC, 1);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(c1);
        cart.addItem(c2);
        cart.addItem(c3);


        // when
        int actualTotal = promotionEngine.calculateTotalValue(cart, List.of(p1, p2, p3));


        // then
        assertEquals(actualTotal, 100);
    }

    @Test
    public void should_return_expected_total_value_for_scenario_2() {
        // given

        CartItem c1 = new CartItem(pA, 5);
        CartItem c2 = new CartItem(pB, 5);
        CartItem c3 = new CartItem(pC, 1);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(c1);
        cart.addItem(c2);
        cart.addItem(c3);


        // when
        int actualTotal = promotionEngine.calculateTotalValue(cart, List.of(p1, p2, p3));


        // then
        assertEquals(actualTotal, 370);
    }

    @Test
    public void should_return_expected_total_value_for_scenario_3() {
        // given

        CartItem c1 = new CartItem(pA, 3);
        CartItem c2 = new CartItem(pB, 5);
        CartItem c3 = new CartItem(pC, 1);
        CartItem c4 = new CartItem(pD, 1);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(c1);
        cart.addItem(c2);
        cart.addItem(c3);
        cart.addItem(c4);


        // when
        int actualTotal = promotionEngine.calculateTotalValue(cart, List.of(p1, p2, p3));


        // then
        assertEquals(actualTotal, 280);
    }

    @Test
    public void should_return_expected_total_value_for_scenario_4() {
        // given

        CartItem c1 = new CartItem(pA, 3);
        CartItem c2 = new CartItem(pB, 5);
        CartItem c3 = new CartItem(pC, 3);
        CartItem c4 = new CartItem(pD, 3);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(c1);
        cart.addItem(c2);
        cart.addItem(c3);
        cart.addItem(c4);


        // when
        int actualTotal = promotionEngine.calculateTotalValue(cart, List.of(p1, p2, p3));


        // then
        assertEquals(actualTotal, 340);
    }

    @Test
    public void should_return_expected_total_value_for_scenario_5() {
        // given

        CartItem c1 = new CartItem(pA, 3);
        CartItem c2 = new CartItem(pB, 5);
        CartItem c3 = new CartItem(pC, 4);
        CartItem c4 = new CartItem(pD, 3);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(c1);
        cart.addItem(c2);
        cart.addItem(c3);
        cart.addItem(c4);


        // when
        int actualTotal = promotionEngine.calculateTotalValue(cart, List.of(p1, p2, p3));


        // then
        assertEquals(actualTotal, 360);
    }

    @Test
    public void should_return_expected_total_value_for_scenario_6() {
        // given

        CartItem c1 = new CartItem(pA, 3);
        CartItem c2 = new CartItem(pB, 5);
        CartItem c3 = new CartItem(pC, 3);
        CartItem c4 = new CartItem(pD, 4);
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(c1);
        cart.addItem(c2);
        cart.addItem(c3);
        cart.addItem(c4);


        // when
        int actualTotal = promotionEngine.calculateTotalValue(cart, List.of(p1, p2, p3));


        // then
        assertEquals(actualTotal, 355);
    }
}
