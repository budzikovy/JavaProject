package services;

import model.Order;
import model.Product;

import java.util.Map;

/**
 * Service class to generate invoices for orders.
 */

public class InvoiceService {

    /**
     * Generates and prints an invoice for the given order.
     * @param order the order for which the invoice is generated
     */

    public void generateInvoice(Order order) {
        System.out.println("Invoice for Order ID: " + order.getOrderId());
        System.out.println("Customer Name: " + order.getCustomerName());
        System.out.println("Customer Email: " + order.getCustomerEmail());
        System.out.println("Ordered Products:");
        for (Map.Entry<Product, Integer> entry : order.getOrderedProducts().entrySet()) {
            System.out.println(entry.getKey().getName() + " - Quantity: " + entry.getValue() + " - Price: $" + entry.getKey().getPrice());
        }
        System.out.println("Total Amount: $" + order.getTotalAmount());
        System.out.println("Order Time: " + order.getOrderTime());
        System.out.println("=====================================");
    }
}
