class Shop extends Building {
    private String businessType;

    public Shop(String address, String name, double size, String businessType) {
        super(address, name, size);
        this.businessType = businessType;
    }

    @Override
    public double calculateRent() {
        return getSize() * 15 + (businessType.equals("Retail") ? 100 : 0); // Example calculation
    }
}