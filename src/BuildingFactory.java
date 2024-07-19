class BuildingFactory {
    public static Building createBuilding(String type, String address, String name, double size, Object... additionalParams) {
        switch (type) {
            case "Apartment":
                int floor = (int) additionalParams[0];
                return new Apartment(address, name, size, floor);
            case "House":
                boolean hasGarden = (boolean) additionalParams[0];
                return new House(address, name, size, hasGarden);
            case "Shop":
                String businessType = (String) additionalParams[0];
                return new Shop(address, name, size, businessType);
            default:
                throw new IllegalArgumentException("Unknown building type: " + type);
        }
    }
}
