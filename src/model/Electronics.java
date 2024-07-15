package model;

import java.io.Serializable;

/**
 * Represents an electronics product extending the Product class and implementing Serializable.
 * This serves as a base class for various types of electronic products.
 */

public class Electronics extends Product implements Serializable {

    /**
     * Constructs a new Electronics object with specified attributes.
     * @param id the unique identifier of the electronics product
     * @param name the name of the electronics product
     * @param price the price of the electronics product
     * @param availableQuant the available quantity of the electronics product
     */

    public Electronics(int id, String name, double price, int availableQuant) {
        super(id, name, price, availableQuant, "Electronics");
    }
}
