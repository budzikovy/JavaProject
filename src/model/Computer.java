package model;

import enums.ComputerProcessor;
import enums.ComputerRAM;
import enums.ComputerStorage;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a computer product with specific hardware specifications.
 * Extends the Product class and implements Serializable.
 */

public class Computer extends Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 6234742785698869717L;
    private ComputerProcessor processor;
    private ComputerRAM ram;
    private ComputerStorage storage;

    /**
     * Constructs a new Computer object with specified attributes.
     * @param id the unique identifier of the computer
     * @param name the name of the computer
     * @param price the price of the computer
     * @param availableQuant the available quantity of the computer
     * @param processor the processor type of the computer
     * @param ram the RAM size of the computer
     * @param storage the storage capacity of the computer
     */

    public Computer(int id, String name, double price, int availableQuant, ComputerProcessor processor, ComputerRAM ram, ComputerStorage storage) {
        super(id, name, price, availableQuant, "Computer");
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

    public ComputerProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(ComputerProcessor processor) {
        this.processor = processor;
    }

    public ComputerRAM getRam() {
        return ram;
    }

    public void setRam(ComputerRAM ram) {
        this.ram = ram;
    }

    public ComputerStorage getStorage() {
        return storage;
    }

    public void setStorage(ComputerStorage storage) {
        this.storage = storage;
    }

    /**
     * Configures the specifications (processor, RAM, storage) of the computer.
     * @param processor the processor type to set
     * @param ram the RAM size to set
     * @param storage the storage capacity to set
     */

    public void configureSpecifications(ComputerProcessor processor, ComputerRAM ram, ComputerStorage storage) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", availableQuant=" + getAvailableQuant() +
                ", cpu='" + processor + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                '}';
    }
}
