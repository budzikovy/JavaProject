package services;

import exceptions.OrderProcessingException;
import exceptions.ProductOutOfStockException;
import model.Cart;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.List;

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
     * @return the product with the specified ID, or null if not found
     */

    public Product getProductById(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    /**
     * Adds a specified quantity of a product to the cart.
     * Throws ProductOutOfStockException if the product is out of stock or insufficient quantity is available.
     * @param productId the ID of the product to add to the cart
     * @param quantity the quantity of the product to add
     * @throws ProductOutOfStockException if the product is out of stock or quantity exceeds available stock
     */

    public void addProductToCart(int productId, int quantity) throws ProductOutOfStockException {
        Product product = getProductById(productId);
        if (product != null && quantity <= product.getAvailableQuant()) {
            cart.addProductToCart(product, quantity);
            product.setAvailableQuant(product.getAvailableQuant() - quantity);
            System.out.println("Product added to cart: " + product + " | Quantity: " + quantity);
        } else {
            throw new ProductOutOfStockException("Product is out of stock or you provided a quantity larger than the available stock.");
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
        if (cart.getCartItems().isEmpty()) {
            throw new OrderProcessingException("Cart is empty. Add something to the cart.");
        } else {
            orderService.processOrder(customerName, customerEmail, cart.getCartItems(), discountCode);
        }
        cart.clearCart();
    }

    public void viewOrders() {
        System.out.println("\nViewing Orders:");
        for (Order order : orderService.getOrders()) {
            System.out.println(order);
        }
    }
}
