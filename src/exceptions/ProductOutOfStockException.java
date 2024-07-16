package exceptions;

 /**
 * Custom exception class for indicating that a product is out of stock.
 * This exception is thrown when attempting to access or order a product that is not available.
 */

public class ProductOutOfStockException extends Exception {
    public ProductOutOfStockException(String message) {
        super(message);
    }
}