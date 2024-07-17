package services;

import exceptions.OrderProcessingException;
import exceptions.ProductOutOfStockException;
import model.Cart;
import model.CartItem;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing products, carts, and order processing.
 */

public class ProductService {

    private List<Product> products;
    private Cart cart;
    private OrderService orderService;
    private int nextProductId;

    /**
     * Constructs a ProductService instance, initializing the list of products, cart, and order service.
     */

    public ProductService() {
        products = new ArrayList<>();
        cart = new Cart();
        orderService = new OrderService();
        nextProductId = 1;
    }

    public int getNextProductId() {
        return nextProductId++;
    }

    public void addProduct(Product product) {
        product.setId(getNextProductId());
        products.add(product);
    }

    public boolean removeProduct(int productId) {
        return products.removeIf(product -> product.getId() == productId);
    }

    public List<Product> viewProducts() {
        return products;
    }

    /**
     * Retrieves a product from the list based on its ID.
     * @param productId the ID of the product to retrieve
     * @return an Optional containing the product with the specified ID, or an empty Optional if not found
     */


//    Zmiany
    public Optional<Product> getProductById(int productId) {
        return products.stream()
                .filter(product -> product.getId() == productId)
                .findFirst();
    }

    /**
     * Adds a specified quantity of a product to the cart.
     * Throws ProductOutOfStockException if the product is out of stock or insufficient quantity is available.
     * @param productId the ID of the product to add to the cart
     * @param quantity the quantity of the product to add
     * @throws ProductOutOfStockException if the product is out of stock or quantity exceeds available stock
     */

//    Zmiany
    public void addProductToCart(int productId, int quantity) throws ProductOutOfStockException {
        Optional<Product> productOptional = getProductById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            if (quantity <= product.getAvailableQuant()) {
                cart.addProductToCart(product, quantity);
                product.setAvailableQuant(product.getAvailableQuant() - quantity);
                System.out.println("Product added to cart: " + product + " | Quantity: " + quantity);
            } else {
                throw new ProductOutOfStockException("Product is out of stock or you provided a quantity larger than the available stock.");
            }
        } else {
            throw new ProductOutOfStockException("Product not found with ID: " + productId);
        }
    }

    public void viewCart() {
        cart.viewCart();
    }

    /**
     * Processes the items in the cart to place an order.
     * Throws OrderProcessingException if the cart is empty.
     * @param customerName the name of the customer placing the order
     * @param customerEmail the email of the customer placing the order
     * @param discountCode the discount code to apply to the order (can be null)
     * @throws OrderProcessingException if the cart is empty
     */

    public void placeOrder(String customerName, String customerEmail, String discountCode) throws OrderProcessingException {
        List<CartItem> cartItems = cart.getCartItems();
        if (cartItems.isEmpty()) {
            throw new OrderProcessingException("Cart is empty. Add something to the cart.");
        } else {
            orderService.processOrder(customerName, customerEmail, cartItems, discountCode);
        }
        cart.clearCart();
    }

    public void viewOrders() {
        System.out.println("\nViewing Orders:");
        orderService.getOrders().forEach(System.out::println);
    }
}
