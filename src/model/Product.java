package model;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a generic product with basic attributes such as ID, name, price, available quantity, and type.
 * Implements Serializable to support object serialization.
 */

public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 4573766951682028545L;
    private int id;
    private String name;
    private double price;
    private int availableQuant;
    private String type;

    /**
     * Constructs a new Product object with specified attributes.
     * @param id the unique identifier of the product
     * @param name the name of the product
     * @param price the price of the product
     * @param availableQuant the available quantity of the product
     * @param type the type or category of the product
     */

    public Product(int id, String name, double price, int availableQuant, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.availableQuant = availableQuant;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableQuant() {
        return availableQuant;
    }

    public void setAvailableQuant(int availableQuant) {
        this.availableQuant = availableQuant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", availableQuant=" + availableQuant +
                ", type='" + type + '\'' +
                '}';
    }
}
