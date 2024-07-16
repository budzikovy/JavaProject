package enums;

/**
 * Enum type representing different smartphone battery capacities.
 * Each battery capacity is specified in milliampere-hours (mAh).
 */

public enum SmartphoneBatteryCapacity {
    BATTERY_3000MAH(3000), BATTERY_4000MAH(4000), BATTERY_5000MAH(5000), BATTERY_6000MAH(6000), BATTERY_6500MAH(6500);

    private final int capacity;

    SmartphoneBatteryCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}