package model;

/**
 * Represents an item in the cart, which includes a product and its quantity.
 */

public class CartItem {

    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return product + " | Quantity: " + quantity;
    }
}
