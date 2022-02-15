package pricing.offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import product.Product;

class LowestPricePerUnitTest {

    @ParameterizedTest
    @CsvSource({"1, 5.0" , "2, 10.0"})
    public void when_there_are_few_units_then_price_per_unit_is_default(int quantity, double priceExpected) {
        LowestPricePerUnit lowestPricePerUnit = new LowestPricePerUnit(2.0, 3);
        double price = lowestPricePerUnit.calculatePrice(product(), quantity);
        Assertions.assertEquals(priceExpected, price);
    }

    @ParameterizedTest
    @CsvSource({"3, 6.0" , "4, 8.0"})
    public void when_there_are_many_units_then_price_per_unit_is_lowest(int quantity, double priceExpected) {
        LowestPricePerUnit lowestPricePerUnit = new LowestPricePerUnit(2.0, 3);
        double price = lowestPricePerUnit.calculatePrice(product(), quantity);
        Assertions.assertEquals(priceExpected, price);
    }

    private Product product() {
        return new Product("code", "name", 5.0);
    }

}