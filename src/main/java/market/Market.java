package market;

import error.ProductNotFoundException;
import pricing.StandardPriceCalculator;
import pricing.offer.PriceOffer;
import product.Basket;
import product.Product;

import java.util.HashMap;
import java.util.Map;

public class Market {

    private final Map<String, Product> products;
    private final Map<String, PriceOffer> priceOfferByProducts;

    public Market() {
        this.products = new HashMap<>();
        this.priceOfferByProducts = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getCode(), product);
    }

    public void addPriceOffer(String productCode, PriceOffer priceOffer) {
        validateProduct(productCode);
        priceOfferByProducts.put(productCode, priceOffer);
    }

    public Double price(String productCode, int quantity) {
        Product product = findProduct(productCode);
        if (hasAnOffer(productCode)) {
            PriceOffer priceOffer = priceOfferByProducts.get(productCode);
            return priceOffer.calculatePrice(product, quantity);
        }
        return StandardPriceCalculator.price(product, quantity);
    }

    public double price(Basket basket) {
        return basket.items().stream().mapToDouble(
                item -> price(item.getProductCode(), item.getQuantity())).sum();
    }

    private Product findProduct(String productCode) {
        validateProduct(productCode);
        return products.get(productCode);
    }

    private void validateProduct(String productCode) {
        if (!products.containsKey(productCode)) {
            throw new ProductNotFoundException(productCode);
        }
    }

    private boolean hasAnOffer(String productCode) {
        return priceOfferByProducts.containsKey(productCode);
    }
}
