package enums;

/**
 * Enum type representing different computer RAM options.
 * Each RAM option has a specified size in gigabytes (GB).
 */

public enum ComputerRAM {
    RAM_2GB(2), RAM_4GB(4), RAM_8GB(8), RAM_16GB(16), RAM_32GB(32);

    private final int size;

    ComputerRAM(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}