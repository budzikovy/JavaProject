package services;

import model.CartItem;
import model.Order;
import model.Product;

import java.util.*;

/**
 * Service class for managing orders, processing orders, and interacting with related services.
 */

public class OrderService {

    private List<Order> orders;
    private static int orderCounter = 1;
    private InvoiceService invoiceService;
    private OrderPersistenceService orderPersistenceService;
    private DiscountService discountService;

    /**
     * Constructs an OrderService instance, initializing necessary services and loading existing orders.
     */

//    Zmiany
    public OrderService() {
        orderPersistenceService = new OrderPersistenceService();
        orders = orderPersistenceService.loadOrders();
        orderCounter = orders.stream()
                .mapToInt(Order::getOrderId)
                .max()
                .orElse(0) + 1;
        invoiceService = new InvoiceService();
        discountService = new DiscountService();
    }


    public List<Order> getOrders() {
        return orders;
    }

    public static int getOrderCounter() {
        return orderCounter;
    }

    public static void setOrderCounter(int orderCounter) {
        OrderService.orderCounter = orderCounter;
    }

    /**
     * Processes a new order with customer details, cart items, and optional discount code.
     * Generates an invoice, applies discounts if valid, and persists the order.
     *
     * @param customerName  the name of the customer placing the order
     * @param customerEmail the email of the customer placing the order
     * @param cartItems     a list of CartItem objects representing products and their quantities in the customer's cart
     * @param discountCode  the discount code to apply to the order (can be null)
     */

//    Zmiany
    public void processOrder(String customerName, String customerEmail, List<CartItem> cartItems, String discountCode) {
        Map<Product, Integer> orderedProducts = new HashMap<>();

        for (CartItem cartItem : cartItems) {
            orderedProducts.put(cartItem.getProduct(), cartItem.getQuantity());
        }

        Order order = new Order(orderCounter++, customerName, customerEmail, orderedProducts);

        Optional<Double> discount = Optional.ofNullable(discountCode)
                .filter(discountService::isValidDiscountCode)
                .map(discountService::getDiscount);

        discount.ifPresent(d -> {
            double totalAmount = order.getTotalAmount();
            order.setTotalAmount(totalAmount - (totalAmount * d));
        });

        orders.add(order);
        invoiceService.generateInvoice(order);
        orderPersistenceService.saveOrders(orders);
    }

}
