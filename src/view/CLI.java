package view;

import enums.*;
import exceptions.OrderProcessingException;
import exceptions.ProductOutOfStockException;
import model.Computer;
import model.Product;
import model.Smartphone;
import services.ProductService;

import java.util.EnumSet;
import java.util.Scanner;
import java.util.Set;

/**
 * CLI class provides a Command Line Interface for interacting with the Online Store.
 */
public class CLI {

    private final ProductService productService;
    private final Scanner scanner;

    /**
     * Constructor for CLI.
     *
     * @param productService an instance of ProductService
     */
    public CLI(ProductService productService) {
        this.productService = productService;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the command line interface and handles user input.
     */
    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\nWelcome to the Online Store");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. View Orders");
            System.out.println("6. Admin Panel");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addProductToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    placeOrder();
                    break;
                case 5:
                    viewOrders();
                    break;
                case 6:
                    startAdminPanel();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private void viewProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : productService.viewProducts()) {
            System.out.println(product);
        }
    }

    /**
     * Prompts the user to add a product to the cart by entering product ID and quantity.
     */
    private void addProductToCart() {
        System.out.print("\nEnter Product ID to add to cart: ");
        int productId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product product = productService.getProductById(productId);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        if (product instanceof Smartphone) {
            System.out.print("Do you want to configure the specifications? (yes/no): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                configureSmartphone((Smartphone) product);
            }
        } else if (product instanceof Computer) {
            System.out.print("Do you want to configure the specifications? (yes/no): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                configureComputer((Computer) product);
            }
        }

        try {
            productService.addProductToCart(productId, quantity);
            System.out.println("Product successfully added to cart.");
        } catch (ProductOutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Configures specifications for a smartphone product.
     *
     * @param smartphone the smartphone to configure
     */
    private void configureSmartphone(Smartphone smartphone) {
        SmartphoneColor color = chooseColor();
        SmartphoneBatteryCapacity batteryCapacity = chooseBattery();
        Set<SmartphoneAccessory> accessories = chooseAccessories();

        smartphone.configureSpecifications(color, batteryCapacity, accessories);
        System.out.println("Smartphone specifications configured successfully.");
    }

    /**
     * Prompts the user to choose a smartphone color.
     *
     * @return the chosen SmartphoneColor
     */
    private SmartphoneColor chooseColor() {
        System.out.println("Available Colors: ");
        SmartphoneColor[] colors = SmartphoneColor.values();
        for (int i = 0; i < colors.length; i++) {
            System.out.println((i + 1) + ". " + colors[i]);
        }
        System.out.print("Enter Color: ");
        int colorChoice = scanner.nextInt();
        scanner.nextLine();
        return colors[colorChoice - 1];
    }

    /**
     * Prompts the user to choose a smartphone battery capacity.
     *
     * @return the chosen SmartphoneBatteryCapacity
     */
    private SmartphoneBatteryCapacity chooseBattery() {
        System.out.println("Available Battery Capacities: ");
        SmartphoneBatteryCapacity[] batteries = SmartphoneBatteryCapacity.values();
        for (int i = 0; i < batteries.length; i++) {
            System.out.println((i + 1) + ". " + batteries[i]);
        }
        System.out.print("Enter Battery Capacity: ");
        int batteryChoice = scanner.nextInt();
        scanner.nextLine();
        return batteries[batteryChoice - 1];
    }

    /**
     * Prompts the user to choose smartphone accessories.
     *
     * @return a set of chosen SmartphoneAccessory
     */
    private Set<SmartphoneAccessory> chooseAccessories() {
        System.out.println("Available Accessories: ");
        SmartphoneAccessory[] accessoriesArray = SmartphoneAccessory.values();
        for (int i = 0; i < accessoriesArray.length; i++) {
            System.out.println((i + 1) + ". " + accessoriesArray[i]);
        }
        System.out.print("Enter Accessory choices (comma separated): ");
        String accessoryChoices = scanner.nextLine();
        String[] choices = accessoryChoices.split(",");
        Set<SmartphoneAccessory> accessories = EnumSet.noneOf(SmartphoneAccessory.class);
        for (String choice : choices) {
            accessories.add(accessoriesArray[Integer.parseInt(choice.trim()) - 1]);
        }
        return accessories;
    }

    /**
     * Configures specifications for a computer product.
     *
     * @param computer the computer to configure
     */
    private void configureComputer(Computer computer) {
        ComputerProcessor processor = chooseProcessor();
        ComputerRAM ram = chooseRAM();
        ComputerStorage storage = chooseStorage();

        computer.configureSpecifications(processor, ram, storage);
        System.out.println("Computer specifications configured successfully.");
    }

    /**
     * Prompts the user to choose a computer processor.
     *
     * @return the chosen ComputerProcessor
     */
    private ComputerProcessor chooseProcessor() {
        System.out.println("Available Processors: ");
        ComputerProcessor[] processors = ComputerProcessor.values();
        for (int i = 0; i < processors.length; i++) {
            System.out.println((i + 1) + ". " + processors[i]);
        }
        System.out.print("Enter Processor: ");
        int processorChoice = scanner.nextInt();
        scanner.nextLine();
        return processors[processorChoice - 1];
    }

    /**
     * Prompts the user to choose a computer RAM size.
     *
     * @return the chosen ComputerRAM
     */
    private ComputerRAM chooseRAM() {
        System.out.println("Available RAM Sizes: ");
        ComputerRAM[] rams = ComputerRAM.values();
        for (int i = 0; i < rams.length; i++) {
            System.out.println((i + 1) + ". " + rams[i].getSize() + "GB");
        }
        System.out.print("Enter RAM Size: ");
        int ramChoice = scanner.nextInt();
        scanner.nextLine();
        return rams[ramChoice - 1];
    }

    /**
     * Prompts the user to choose a computer storage size.
     *
     * @return the chosen ComputerStorage
     */
    private ComputerStorage chooseStorage() {
        System.out.println("Available Storage Sizes: ");
        ComputerStorage[] storages = ComputerStorage.values();
        for (int i = 0; i < storages.length; i++) {
            System.out.println((i + 1) + ". " + storages[i].getSize() + "GB");
        }
        System.out.print("Enter Storage Size: ");
        int storageChoice = scanner.nextInt();
        scanner.nextLine();
        return storages[storageChoice - 1];
    }

    private void viewCart() {
        System.out.println("\nCart Contents:");
        productService.viewCart();
    }

    /**
     * Places an order with the customer details and optional discount code.
     */
    private void placeOrder() {
        System.out.print("\nEnter Customer Name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter Customer Email: ");
        String customerEmail = scanner.nextLine();

        System.out.print("Do you have a discount code? (yes/no): ");
        String hasDiscountCode = scanner.nextLine();
        String discountCode = null;

        if (hasDiscountCode.equalsIgnoreCase("yes")) {
            System.out.print("Enter Discount Code: ");
            discountCode = scanner.nextLine();
        }

        try {
            productService.placeOrder(customerName, customerEmail, discountCode);
            System.out.println("Order placed successfully!");
        } catch (OrderProcessingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewOrders() {
        productService.viewOrders();
    }

    private void startAdminPanel() {
        AdminPanel adminPanel = new AdminPanel(productService, scanner);
        adminPanel.start();
    }
}
