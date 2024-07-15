package exceptions;

/**
 * Custom exception class for handling errors related to order processing.
 * This exception is thrown to indicate issues encountered during order processing.
 */

public class OrderProcessingException extends Exception {
    public OrderProcessingException(String message) {
        super(message);
    }
}