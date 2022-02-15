package pricing.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import product.Product;

class proportionalPriceTest {

    @Test
    public void when_there_are_few_units_then_does_not_apply_proportional_factor() {
        PriceOffer proportionalPrice = new ProportionalPrice((double) 2/3, 3);
        double price = proportionalPrice.calculatePrice(product(), 2);
        Assertions.assertEquals(10.0, price);
    }

    @Test
    public void when_there_are_many_units_then_apply_proportional_factor() {
        PriceOffer proportionalPrice = new ProportionalPrice((double) 2/3, 3);
        double price = proportionalPrice.calculatePrice(product(), 6);
        Assertions.assertEquals(20.0, price);
    }

    private Product product() {
        return new Product("code", "name", 5.0);
    }
}