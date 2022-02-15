package product;

public class Item {

    private final String productCode;
    private final int quantity;

    public Item(String productCode, int quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public static Item of(String productCode, int quantity) {
        return new Item(productCode, quantity);
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }
}
