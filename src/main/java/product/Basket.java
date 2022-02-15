package product;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private final List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public Basket(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> items() {
        return items;
    }
}
