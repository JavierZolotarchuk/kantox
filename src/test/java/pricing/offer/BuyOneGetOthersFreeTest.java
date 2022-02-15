package pricing.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import product.Product;


class BuyOneGetOthersFreeTest {

    @Test
    public void buy_one_get_one_free() {
        BuyOneGetOthersFree buyOneGetOneFree = new BuyOneGetOthersFree(1, 1);
        double price = buyOneGetOneFree.calculatePrice(product(), 10);
        Assertions.assertEquals(5.0, price);
    }

    @Test
    public void buy_one_get_two_free() {
        BuyOneGetOthersFree buyOneGetTwoFree = new BuyOneGetOthersFree(2, 1);
        double price = buyOneGetTwoFree.calculatePrice(product(), 6);
        Assertions.assertEquals(2.0, price);
    }

    @Test
    public void buy_one_get_three_free() {
        BuyOneGetOthersFree buyOneGetThreeFree = new BuyOneGetOthersFree(3, 1);
        double price = buyOneGetThreeFree.calculatePrice(product(), 9);
        Assertions.assertEquals(3.0, price);
    }

    private Product product() {
        return new Product("code", "name", 1.0);
    }
}