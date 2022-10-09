import com.yasho.PromotionEngine;
import com.yasho.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class CartPromotionTest {

    PromotionEngine promotionEngine;

    Product pA = new Product("A", 50);
    Product pB = new Product("B", 30);
    Product pC = new Product("C", 20);
    Product pD = new Product("D", 15);

    Promotion p1 = new ComboOfferPromotion(Map.of(pA, 3), 130);
    Promotion p2 = new ComboOfferPromotion(Map.of(pB, 2), 45);

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

        promotionEngine = new PromotionEngine(cart, List.of(p1, p2));

        // when

        // then

    }
}
