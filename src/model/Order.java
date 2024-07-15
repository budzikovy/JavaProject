package model;

import java.io.Serial;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * Represents an order made by a customer, containing details such as products ordered, total amount,
 * and order timestamp. Implements Serializable to support object serialization.
 */

public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = -7680400700601563407L;
    private int orderId;
    private String customerName;
    private String customerEmail;
    private Map<Product, Integer> orderedProducts;
    private double totalAmount;
    private ZonedDateTime orderTime;

    /**
     * Constructs a new Order object with specified attributes.
     * @param orderId the unique identifier of the order
     * @param customerName the name of the customer placing the order
     * @param customerEmail the email of the customer placing the order
     * @param orderedProducts the map of products ordered and their quantities
     */

    public Order(int orderId, String customerName, String customerEmail, Map<Product, Integer> orderedProducts) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderedProducts = orderedProducts;
        this.totalAmount = calculateTotalAmount();
        this.orderTime = ZonedDateTime.now();
    }

    public ZonedDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(ZonedDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Map<Product, Integer> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(Map<Product, Integer> orderedProducts) {
        this.orderedProducts = orderedProducts;
        this.totalAmount = calculateTotalAmount();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Calculates and returns the total amount (price) of the order based on ordered products and their quantities.
     * @return the calculated total amount of the order
     */

    private double calculateTotalAmount() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : orderedProducts.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", orderedProducts=" + orderedProducts +
                ", totalAmount=" + totalAmount +
                ", orderTime=" + orderTime +
                '}';
    }
}
