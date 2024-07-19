class House extends Building {
    private boolean hasGarden;

    public House(String address, String name, double size, boolean hasGarden) {
        super(address, name, size);
        this.hasGarden = hasGarden;
    }

    @Override
    public double calculateRent() {
        return getSize() * 12 + (hasGarden ? 50 : 0);
    }
}