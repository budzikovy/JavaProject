package view;

import enums.*;
import model.Computer;
import model.Electronics;
import model.Product;
import model.Smartphone;
import services.ProductService;

import java.util.EnumSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Class representing the admin panel for managing products.
 */

public class AdminPanel {

    private final ProductService productService;
    private final Scanner scanner;

    /**
     * Constructs an AdminPanel with a ProductService and Scanner instance.
     * @param productService the ProductService instance to manage products
     * @param scanner the Scanner instance to read user input
     */

    public AdminPanel(ProductService productService, Scanner scanner) {
        this.productService = productService;
        this.scanner = scanner;
    }

    public void start() {
        boolean adminRunning = true;

        while (adminRunning) {
            System.out.println("\nAdmin Panel");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. Exit Admin Panel");
            System.out.print("Choose an option: ");

            int adminChoice = scanner.nextInt();
            scanner.nextLine();

            switch (adminChoice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    adminRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Prompts the user to add a new product based on user input.
     */

    private void addProduct() {
        System.out.print("\nEnter Product Type (1. Computer, 2. Smartphone, 3. Electronics): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        switch (type) {
            case 1:
                addComputer();
                break;
            case 2:
                addSmartphone();
                break;
            case 3:
                addElectronics();
                break;
            default:
                System.out.println("Invalid product type.");
        }
    }

    /**
     * Prompts the user to add a new Computer product based on user input.
     */

    private void addComputer() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        ComputerProcessor processor = chooseProcessor();
        ComputerRAM ramSize = chooseRAM();
        ComputerStorage storageSize = chooseStorage();

        Computer computer = new Computer(productService.getNextProductId(), name, price, quantity, processor, ramSize, storageSize);
        productService.addProduct(computer);
        System.out.println("Computer added successfully.");
    }

    /**
     * Prompts the user to add a new Smartphone product based on user input.
     */

    private void addSmartphone() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        SmartphoneColor color = chooseColor();
        SmartphoneBatteryCapacity batteryCapacity = chooseBattery();
        Set<SmartphoneAccessory> accessories = chooseAccessories();

        Smartphone smartphone = new Smartphone(productService.getNextProductId(), name, price, quantity, color, batteryCapacity, accessories);
        productService.addProduct(smartphone);
        System.out.println("Smartphone added successfully.");
    }

    /**
     * Prompts the user to add a new Electronics product based on user input.
     */

    private void addElectronics() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Electronics electronics = new Electronics(productService.getNextProductId(), name, price, quantity);
        productService.addProduct(electronics);
        System.out.println("Electronics added successfully.");
    }

    /**
     * Prompts the user to remove a product based on user input.
     */

    private void removeProduct() {
        System.out.print("\nEnter Product ID to remove: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        boolean removed = productService.removeProduct(productId);
        if (removed) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    /**
     * Prompts the user to update a product based on user input.
     */

    private void updateProduct() {
        System.out.print("\nEnter Product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = productService.getProductById(productId);
        if (product != null) {
            System.out.println("Current Product Details: " + product);
            System.out.println("Enter New Details:");

            switch (product) {
                case Computer computer -> updateComputer(computer);
                case Smartphone smartphone -> updateSmartphone(smartphone);
                case Electronics electronics -> updateElectronics(electronics);
                default -> System.out.println("Invalid product type.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    /**
     * Method to update details of a Computer product based on user input.
     * @param computer the Computer product to update
     */

    private void updateComputer(Computer computer) {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        ComputerProcessor processor = chooseProcessor();
        ComputerRAM ramSize = chooseRAM();
        ComputerStorage storageSize = chooseStorage();

        computer.setName(name);
        computer.setPrice(price);
        computer.setAvailableQuant(quantity);
        computer.setProcessor(processor);
        computer.setRam(ramSize);
        computer.setStorage(storageSize);

        System.out.println("Computer updated successfully.");
    }

    /**
     * Method to update details of a Smartphone product based on user input.
     * @param smartphone the Smartphone product to update
     */

    private void updateSmartphone(Smartphone smartphone) {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        SmartphoneColor color = chooseColor();
        SmartphoneBatteryCapacity batteryCapacity = chooseBattery();
        Set<SmartphoneAccessory> accessories = chooseAccessories();

        smartphone.setName(name);
        smartphone.setPrice(price);
        smartphone.setAvailableQuant(quantity);
        smartphone.setColor(color);
        smartphone.setBatteryCapacity(batteryCapacity);
        smartphone.setAccessories(accessories);

        System.out.println("Smartphone updated successfully.");
    }

    /**
     * Method to update details of a Electronics product based on user input.
     * @param electronics the Electronics product to update
     */

    private void updateElectronics(Electronics electronics) {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        electronics.setName(name);
        electronics.setPrice(price);
        electronics.setAvailableQuant(quantity);

        System.out.println("Electronics updated successfully.");
    }

    /**
     * Method to choose a ComputerProcessor from available options.
     * @return the chosen ComputerProcessor
     */

    private ComputerProcessor chooseProcessor() {
        System.out.println("Available Processors: ");
        for (int i = 0; i < ComputerProcessor.values().length; i++) {
            System.out.println((i + 1) + ". " + ComputerProcessor.values()[i]);
        }
        System.out.print("Enter Processor: ");
        int processorChoice = scanner.nextInt();
        scanner.nextLine();
        return ComputerProcessor.values()[processorChoice - 1];
    }

    /**
     * Method to choose a ComputerRAM from available options.
     * @return the chosen ComputerRAM
     */

    private ComputerRAM chooseRAM() {
        System.out.println("Available RAM Sizes: ");
        for (int i = 0; i < ComputerRAM.values().length; i++) {
            System.out.println((i + 1) + ". " + ComputerRAM.values()[i]);
        }
        System.out.print("Enter RAM Size: ");
        int ramChoice = scanner.nextInt();
        scanner.nextLine();
        return ComputerRAM.values()[ramChoice - 1];
    }

    /**
     * Method to choose a ComputerStorage from available options.
     * @return the chosen ComputerStorage
     */

    private ComputerStorage chooseStorage() {
        System.out.println("Available Storage Sizes: ");
        for (int i = 0; i < ComputerStorage.values().length; i++) {
            System.out.println((i + 1) + ". " + ComputerStorage.values()[i]);
        }
        System.out.print("Enter Storage Size: ");
        int storageChoice = scanner.nextInt();
        scanner.nextLine();
        return ComputerStorage.values()[storageChoice - 1];
    }

    /**
     * Method to choose a SmartphoneColor from available options.
     * @return the chosen SmartphoneColor
     */

    private SmartphoneColor chooseColor() {
        System.out.println("Available Colors: ");
        for (int i = 0; i < SmartphoneColor.values().length; i++) {
            System.out.println((i + 1) + ". " + SmartphoneColor.values()[i]);
        }
        System.out.print("Enter Color: ");
        int colorChoice = scanner.nextInt();
        scanner.nextLine();
        return SmartphoneColor.values()[colorChoice - 1];
    }

    /**
     * Method to choose a SmartphoneBatteryCapacity from available options.
     * @return the chosen SmartphoneBatteryCapacity
     */

    private SmartphoneBatteryCapacity chooseBattery() {
        System.out.println("Available Battery Capacities: ");
        for (int i = 0; i < SmartphoneBatteryCapacity.values().length; i++) {
            System.out.println((i + 1) + ". " + SmartphoneBatteryCapacity.values()[i]);
        }
        System.out.print("Enter Battery Capacity: ");
        int batteryChoice = scanner.nextInt();
        scanner.nextLine();
        return SmartphoneBatteryCapacity.values()[batteryChoice - 1];
    }

    /**
     * Method to choose Smartphone accessories from available options.
     * @return a Set of chosen SmartphoneAccessory
     */

    private Set<SmartphoneAccessory> chooseAccessories() {
        System.out.println("Available Accessories: ");
        for (int i = 0; i < SmartphoneAccessory.values().length; i++) {
            System.out.println((i + 1) + ". " + SmartphoneAccessory.values()[i]);
        }
        System.out.print("Enter Accessory choices (comma separated): ");
        String accessoryChoices = scanner.nextLine();
        String[] choices = accessoryChoices.split(",");
        Set<SmartphoneAccessory> accessories = EnumSet.noneOf(SmartphoneAccessory.class);
        for (String choice : choices) {
            accessories.add(SmartphoneAccessory.values()[Integer.parseInt(choice.trim()) - 1]);
        }
        return accessories;
    }
}
