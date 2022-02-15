package pricing.offer;

import product.Product;

public class LowestPricePerUnit extends PriceOffer {

    private final double newPricePerUnit;

    public LowestPricePerUnit(double newPricePerUnit, int minQuantityToApplyOffer) {
        super(minQuantityToApplyOffer);
        this.newPricePerUnit = newPricePerUnit;
    }

    @Override
    protected double calculatePriceOffer(Product product, int quantity) {
        return quantity * newPricePerUnit;
    }
}
