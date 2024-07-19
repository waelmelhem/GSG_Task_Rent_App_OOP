import java.util.Date;

public class RentBuildingTransaction extends TransactionTemplate {
    private Customer customer;
    private Building building;
    private int rentalPeriod; // in months
    private Contract contract;

    public RentBuildingTransaction(Customer customer, Building building, int rentalPeriod) {
        this.customer = customer;
        this.building = building;
        this.rentalPeriod = rentalPeriod;
    }

    @Override
    protected void selectBuilding() {
        customer.rentBuilding(building);
        System.out.println(customer.getName() + " selected " + building.getName() + " for renting.");
        RentalManager.getInstance().removeBuilding(building);
    }

    @Override
    protected void createContract() {
        double totalRent = building.calculateRent() * rentalPeriod;
        Contract contract = new Contract(customer, building, new Date(), new Date(System.currentTimeMillis() + rentalPeriod * 30L * 24 * 60 * 60 * 1000), totalRent);
        RentalManager.getInstance().addContract(contract);
        this.contract = contract;
        System.out.println("Contract created for " + customer.getName() + " with total rent: " + totalRent);
    }

    @Override
    protected void makePayment() {
        double totalRent = building.calculateRent() * rentalPeriod;
        if (customer.hasPaymentStrategy()) {
            customer.pay(totalRent);
        } else {
            throw new RuntimeException("Customer has no payment strategy.");
        }
    }

    @Override
    protected void rollback() {
        System.out.println("Rolling back transaction...");
        RentalManager.getInstance().addBuildingWithoutObserve(building);
        if (contract != null) {
            RentalManager.getInstance().cancelContract(contract);
            System.out.println("Contract creation rolled back.");

            contract = null;
        }

        if (customer.getRentedBuildings().contains(building)) {
            customer.removeRentedBuilding(building);
            System.out.println("Building selection rolled back.");
        }
    }
}