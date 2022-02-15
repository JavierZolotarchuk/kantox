package market;

import error.ProductNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pricing.offer.BuyOneGetOthersFree;
import product.Basket;
import util.BasketBuilder;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static util.MarketFactory.market;

public class MarketTest {

    @Test
    public void case_1() {
        Basket basket = new BasketBuilder().build("GR1", "SR1", "GR1", "GR1", "CF1");
        double price = market().price(basket);

        Assertions.assertEquals(22.45, price);
    }

    @Test
    public void case_2() {
        Basket basket = new BasketBuilder().build("GR1", "GR1");
        double price = market().price(basket);

        Assertions.assertEquals(3.11, price);
    }

    @Test
    public void case_3() {
        Basket basket = new BasketBuilder().build("SR1", "SR1", "GR1", "SR1");
        double price = market().price(basket);

        Assertions.assertEquals(16.61, price);
    }

    @Test
    public void case_4() {
        Basket basket = new BasketBuilder().build("GR1", "CF1", "SR1", "CF1", "CF1");
        double price = market().price(basket);

        Assertions.assertEquals(30.57, price, 0.00000000000001);
    }

    @Test
    public void when_market_tries_calculate_price_of_an_nonexistent_product_then_fail() {
        String nonexistentProduct = "zzz";
        assertThrows(ProductNotFoundException.class, () -> {
            market().price(nonexistentProduct, 2);
        });
    }

    @Test
    public void when_market_adds_an_price_offer_of_an_nonexistent_product_then_fail() {
        String nonexistentProduct = "zzz";
        assertThrows(ProductNotFoundException.class, () -> market().addPriceOffer(nonexistentProduct, new BuyOneGetOthersFree(1,1)));
    }
}