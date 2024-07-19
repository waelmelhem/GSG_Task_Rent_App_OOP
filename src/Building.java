abstract class Building {
    private String address;
    private String name;
    private double size; // in square meters

    public Building(String address, String name, double size) {
        this.address = address;
        this.name = name;
        this.size = size;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return address + " " + name + " " + size;
    }

    public abstract double calculateRent(); // Abstract method to be implemented by subclasses
}
