package model;

import enums.SmartphoneAccessory;
import enums.SmartphoneBatteryCapacity;
import enums.SmartphoneColor;

import java.io.Serializable;
import java.util.Set;

/**
 * Represents a smartphone product extending the Product class and implementing Serializable.
 * This class encapsulates attributes specific to smartphones such as color, battery capacity,
 * and accessories.
 */

public class Smartphone extends Product implements Serializable {

    private SmartphoneColor color;
    private SmartphoneBatteryCapacity batteryCapacity;
    private Set<SmartphoneAccessory> accessories;

    /**
     * Constructs a new Smartphone object with specified attributes.
     * @param id the unique identifier of the smartphone
     * @param name the name of the smartphone
     * @param price the price of the smartphone
     * @param availableQuant the available quantity of the smartphone
     * @param color the color of the smartphone
     * @param batteryCapacity the battery capacity of the smartphone
     * @param accessories the set of accessories for the smartphone
     */

    public Smartphone(int id, String name, double price, int availableQuant, SmartphoneColor color, SmartphoneBatteryCapacity batteryCapacity, Set<SmartphoneAccessory> accessories) {
        super(id, name, price, availableQuant, "Smartphone");
        this.color = color;
        this.batteryCapacity = batteryCapacity;
        this.accessories = accessories;
    }

    public SmartphoneColor getColor() {
        return color;
    }

    public void setColor(SmartphoneColor color) {
        this.color = color;
    }

    public SmartphoneBatteryCapacity getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(SmartphoneBatteryCapacity batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Set<SmartphoneAccessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<SmartphoneAccessory> accessories) {
        this.accessories = accessories;
    }

    /**
     * Configures the specifications of the smartphone including color, battery capacity, and accessories.
     * @param color the color to set
     * @param batteryCapacity the battery capacity to set
     * @param accessories the set of accessories to set
     */

    public void configureSpecifications(SmartphoneColor color, SmartphoneBatteryCapacity batteryCapacity, Set<SmartphoneAccessory> accessories) {
        this.color = color;
        this.batteryCapacity = batteryCapacity;
        this.accessories = accessories;
    }

    @Override
    public String toString() {
        return super.toString() + " Smartphone [color=" + color + ", batteryCapacity=" + batteryCapacity.getCapacity() + "mAh, accessories=" + accessories + "]";
    }

}
