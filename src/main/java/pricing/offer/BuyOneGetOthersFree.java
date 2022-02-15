package pricing.offer;

import product.Product;

public class BuyOneGetOthersFree extends PriceOffer {

    private final int numberOfFreeUnits;

    public BuyOneGetOthersFree(int numberOfFreeUnits, int minQuantityToApplyOffer) {
        super(minQuantityToApplyOffer);
        this.numberOfFreeUnits = numberOfFreeUnits;
    }

    @Override
    protected double calculatePriceOffer(Product product, int quantity) {
        int unitsToPay = unitsToPay(quantity);
        return calculateStandardPrice(product, unitsToPay);
    }

    private int unitsToPay(int quantity) {
        return (int) Math.ceil((double) quantity / (1 + numberOfFreeUnits));
    }
}
