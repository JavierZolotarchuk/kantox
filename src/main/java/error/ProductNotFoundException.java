package error;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String productCode) {
        super(productCode + " not exist in market");
    }
}
