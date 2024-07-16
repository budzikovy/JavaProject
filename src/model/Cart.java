package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents a shopping cart that holds products and their quantities.
 */
public class Cart {

    private final List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    /**
     * Adds a product with the specified quantity to the cart.
     * If the product is already in the cart, increments the quantity.
     *
     * @param product  the product to add to the cart
     * @param quantity the quantity of the product to add
     */
    public void addProductToCart(Product product, int quantity) {
        Optional<CartItem> existingItem = cartItems.stream()
                .filter(item -> item.getProduct().equals(product))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            cartItems.add(new CartItem(product, quantity));
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
            cartItems.forEach(System.out::println);
        }
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }
}
