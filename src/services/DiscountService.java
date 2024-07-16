package services;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class to manage discount codes and apply discounts.
 */

public class DiscountService {

    private final Map<String, Double> discountCodes;

    public DiscountService() {
        discountCodes = loadDiscountCodes();
    }

    /**
     * Loads initial discount codes into a map.
     * @return a map containing discount codes and their corresponding discount percentages
     */

    private Map<String, Double> loadDiscountCodes() {
        Map<String, Double> codes = new HashMap<>();
        codes.put("SUMMER10", 0.10);
        codes.put("20LESS", 0.20);
        return codes;
    }

    public boolean isValidDiscountCode(String discountCode) {
        return discountCodes.containsKey(discountCode);
    }

    public double getDiscount(String discountCode) {
        return discountCodes.getOrDefault(discountCode, 0.0);
    }
}
