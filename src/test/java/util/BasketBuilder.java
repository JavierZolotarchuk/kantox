package util;

import product.Basket;
import product.Item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasketBuilder {

    private final Map<String, Integer> occurrencesByProductCodes;

    public BasketBuilder() {
        this.occurrencesByProductCodes = new HashMap<>();
    }

    public Basket build(String... productCodes) {
        Arrays.asList(productCodes).forEach(this::add);
        List<Item> items = getItemList();
        return new Basket(items);
    }

    private List<Item> getItemList() {
        return occurrencesByProductCodes.keySet().stream().map(productCode -> {
            Integer quantity = occurrencesByProductCodes.get(productCode);
            return new Item(productCode, quantity);
        }).collect(Collectors.toList());
    }

    private void add(String productCode) {
        if (!occurrencesByProductCodes.containsKey(productCode)) {
            occurrencesByProductCodes.put(productCode, 1);
        } else {
            Integer occurrences = occurrencesByProductCodes.get(productCode);
            occurrencesByProductCodes.put(productCode, occurrences + 1);
        }
    }
}
