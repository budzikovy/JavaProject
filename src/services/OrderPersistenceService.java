package services;

import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class to save and load orders to/from a file using serialization.
 */

public class OrderPersistenceService {

    private static final String FILE_NAME = "orders.dat";

    /**
     * Saves a list of orders to a file using serialization.
     * @param orders the list of orders to save
     */

    public void saveOrders(List<Order> orders) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(orders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads a list of orders from a file using deserialization.
     * @return the list of orders loaded from the file
     */

    public List<Order> loadOrders() {
        List<Order> orders = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            orders = (List<Order>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous orders found, starting with an empty list.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
