package utils;

import enums.*;
import model.Computer;
import model.Electronics;
import model.Smartphone;
import services.ProductService;

import java.util.EnumSet;
import java.util.Set;

/**
 * Utility class to initialize and add initial products to a ProductService instance.
 */

public class Initializer {

    /**
     * Initializes and adds initial products to the provided ProductService instance.
     * @param productService the ProductService instance to add products to
     */

    public static void initializeProducts(ProductService productService) {
        Computer comp = new Computer(1, "Laptop", 1500.0, 10, ComputerProcessor.INTEL_I7, ComputerRAM.RAM_16GB, ComputerStorage.STORAGE_512GB);
        Set<SmartphoneAccessory> accessories = EnumSet.of(SmartphoneAccessory.CASE, SmartphoneAccessory.CHARGER);
        Smartphone phone = new Smartphone(2, "Smartphone", 800.0, 20, SmartphoneColor.BLACK, SmartphoneBatteryCapacity.BATTERY_3000MAH, accessories);
        Electronics tv = new Electronics(3, "Television", 1200.0, 15);

        productService.addProduct(comp);
        productService.addProduct(phone);
        productService.addProduct(tv);
    }
}
