package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a shopping cart that holds products and their quantities.
 */

public class Cart {

    private final Map<Product, Integer> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    /**
     * Adds a product with the specified quantity to the cart.
     * If the product is already in the cart, increments the quantity.
     * @param product the product to add to the cart
     * @param quantity the quantity of the product to add
     */

    public void addProductToCart(Product product, int quantity) {
        if (cartItems.containsKey(product)) {
            cartItems.put(product, cartItems.get(product) + quantity);
        } else {
            cartItems.put(product, quantity);
        }
    }

    /**
     * Displays the contents of the cart.
     * If the cart is empty, prints a message indicating so.
     * Otherwise, prints each product and its quantity in the cart.
     */

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("\nCart is empty.");
        } else {
            System.out.println("\nCart contains: ");
            for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(product + " | Quantity: " + quantity);
            }
        }
    }

    public Map<Product, Integer> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }
}
