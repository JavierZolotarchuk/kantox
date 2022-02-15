package pricing.offer;

import product.Product;

public class ProportionalPrice extends PriceOffer {

    private final double proportionalFactor;

    public ProportionalPrice(double proportionalFactor, int minQuantityToApplyOffer) {
        super(minQuantityToApplyOffer);
        this.proportionalFactor = proportionalFactor;
    }

    @Override
    protected double calculatePriceOffer(Product product, int quantity) {
        return calculateStandardPrice(product, quantity) * proportionalFactor;
    }
}
