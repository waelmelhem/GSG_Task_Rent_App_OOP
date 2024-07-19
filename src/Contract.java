import java.util.Date;

class Contract {
    private Customer customer;
    private Building building;
    private Date startDate;
    private Date endDate;
    private double price;

    public Contract(Customer customer, Building building, Date startDate, Date endDate, double price) {
        this.customer = customer;
        this.building = building;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public String generateContractDetails() {
        return String.format("Contract Details:\nCustomer: %s\nBuilding: %s\nAddress: %s\nRental Period: %s to %s\nPrice: $%.2f",
                customer.getName(), building.getName(), building.getAddress(), startDate, endDate, price);
    }
}