package pricing.offer;

import pricing.StandardPriceCalculator;
import product.Product;

public abstract class PriceOffer {

    protected final int minQuantityToApplyOffer;

    protected PriceOffer(int minQuantityToApplyOffer) {
        this.minQuantityToApplyOffer = minQuantityToApplyOffer;
    }

    public double calculatePrice(Product product, int quantity) {
        if (hasEnoughQuantity(quantity)) {
            return calculatePriceOffer(product, quantity);
        }
        return calculateStandardPrice(product, quantity);
    }

    protected abstract double calculatePriceOffer(Product product, int quantity);

    protected double calculateStandardPrice(Product product, int quantity) {
        return StandardPriceCalculator.price(product, quantity);
    }

    private boolean hasEnoughQuantity(int quantity) {
        return quantity >= minQuantityToApplyOffer;
    }
}
