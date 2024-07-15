# Product Management System

### Project Goal: 
Project goal was to build a comprehensive online store system using Java that provides product management, order processing, customer interaction, and the flexibility for easy configuration and future feature expansion.

### Enums

- `ComputerProcessor.java`, `ComputerRAM.java`, `ComputerStorage.java`, `SmartphoneAccessory.java`, `SmartphoneBatteryCapacity.java`, `SmartphoneColor.java`: Enum classes for various product attributes.

### Exceptions

- `OrderProcessingException.java`, `ProductOutOfStockException.java`: Exception classes for handling custom cases.


### Models

- `Computer.java`, `Electronics.java`, `Product.java`, `Smartphone.java`: 
Model classes representing different types of products.

### Services

- `ProductService.java`, `InvoiceService.java`, `OrderPersistenceService.java`, `OrderService.java`, `DiscountService.java` : Services class handling the business logic for managing products.

### Utils

- `Initializer.java`: Utility class for implementing permanent initial products in the store.

### View

- `AdminPanel.java`: Class that handles command line functionality for Admin methods
- `CLI.java`: Class that handles command line functionality for all users

## Features

- **Add Product**: Add new products (Computers, Smartphones, Electronics) with various attributes.
- **Remove Product**: Remove existing products by their ID.
- **Update Product**: Update details of existing products.
- **Cart**: Add products to the cart with desired quantities and specification and view them.
- **Order**: Place orders with invoice information and view them.
- **Customer Time Zones**: Capture and store customer time zones during checkout.
- **Display Time**: Convert and display order timestamps in the customer's local time zone for clarity.
- **Discounts**: Calculate and apply discounts during the checkout process.
- **Enum Selection**: Easy selection of enum attributes through a utility class.
- **Data Persistence**: Saving order data to files and reading them from the file after restarting the program (orders.dat)


## Usage

1. Run the `Main` class to start the application.
2. Follow the on-screen prompts in terminal.


