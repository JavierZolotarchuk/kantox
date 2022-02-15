package util;

import product.Product;

public class ProductFactory {

    public static Product cf1() {
        return new Product("CF1", "Coffee", 11.23);
    }

    public static Product sr1() {
        return new Product("SR1", "Strawberries", 5.0);
    }

    public static Product gr1() {
        return new Product("GR1", "Green tea", 3.11);
    }


}
