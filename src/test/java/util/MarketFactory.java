package util;

import market.Market;
import pricing.offer.BuyOneGetOthersFree;
import pricing.offer.LowestPricePerUnit;
import pricing.offer.ProportionalPrice;

import static util.ProductFactory.*;

public class MarketFactory {

    public static Market market() {
        Market market = new Market();
        loadProducts(market);
        loadPricingOffers(market);
        return market;
    }

    private static void loadProducts(Market market) {
        market.addProduct(gr1());
        market.addProduct(sr1());
        market.addProduct(cf1());
    }

    private static void loadPricingOffers(Market market) {
        BuyOneGetOthersFree buyOneGetOneFree = new BuyOneGetOthersFree(1, 1);
        market.addPriceOffer("GR1", buyOneGetOneFree);

        LowestPricePerUnit lowestPricePerUnit = new LowestPricePerUnit(4.5, 3);
        market.addPriceOffer("SR1", lowestPricePerUnit);

        ProportionalPrice proportionalPrice = new ProportionalPrice((double) 2/3, 3);
        market.addPriceOffer("CF1", proportionalPrice);
    }

}
