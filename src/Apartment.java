class Apartment extends Building {
    private int floor;

    public Apartment(String address, String name, double size, int floor) {
        super(address, name, size);
        this.floor = floor;
    }

    @Override
    public double calculateRent() {
        return getSize() * 10 + floor * 5;
    }
}