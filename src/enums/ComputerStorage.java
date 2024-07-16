package enums;

/**
 * Enum type representing different computer storage options.
 * Each storage option has a specified size in gigabytes (GB).
 */

public enum ComputerStorage {
    STORAGE_256GB(256), STORAGE_512GB(512), STORAGE_1TB(1024), STORAGE_2TB(2048);

    private  int size;

    ComputerStorage(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
