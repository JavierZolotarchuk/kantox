package pricing;

import product.Product;

public class StandardPriceCalculator {

    public static double price(Product product, int quantity) {
        return product.getPrice() * quantity;
    }

}
