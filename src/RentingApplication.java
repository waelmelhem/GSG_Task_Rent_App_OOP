import java.util.Date;

public class RentingApplication {
    public static void main(String[] args) {
        // Create Rental Manager
        RentalManager rentalManager = RentalManager.getInstance();

        // Create customers
        Customer customer1 = new Customer("Anas Ahmad", "Anas@example.com");
        Customer customer2 = new Customer("Wael Melhem", "Wael@example.com");

        // Add customers as observers
        rentalManager.addObserver(customer1);
        rentalManager.addObserver(customer2);

        // Create buildings using the Factory pattern
        Building apartment = BuildingFactory.createBuilding("Apartment",  "nablus","Horizon", 85.0, 2);
        Building house = BuildingFactory.createBuilding("House",  "Rammalah ","new future", 120.0, true);
        Building shop = BuildingFactory.createBuilding("Shop",  "jenin","al bistan", 20.0, "Retail");

        // Add buildings to Rental Manager
        rentalManager.addBuilding(apartment);
        rentalManager.addBuilding(house);
        rentalManager.addBuilding(shop);

        // Print Rental Manger Details
        System.out.println("--------------------------");
        rentalManager.printRentalMangerDetails();
        System.out.println("--------------------------");


        // Set payment strategy
        customer1.setPaymentStrategy(new PayPalStrategy("Anas@example.com"));
        System.out.println("---------------------------");

        // Create Rent Transaction
        TransactionTemplate rentTransaction = new RentBuildingTransaction(customer1,apartment,12);

        try {
            rentTransaction.execute();
        } catch (Exception e) {
            rentTransaction.rollback();
        }
        customer1.printRentedBuildings();

        System.out.println("---------------------------");

        // Set payment strategy
        customer1.setPaymentStrategy(new CreditCardStrategy("1212-3232-1212-1233","Visa"));

        // Create Rent Transaction
        TransactionTemplate rentTransaction2 = new RentBuildingTransaction(customer1,shop,6);

        try {
            rentTransaction2.execute();
        } catch (Exception e) {
            rentTransaction2.rollback();
        }
        customer1.printRentedBuildings();
        System.out.println("---------------------------");

        // Create Rent Transaction
        TransactionTemplate rentTransaction3 = new RentBuildingTransaction(customer2,house,22);

        try {
            rentTransaction3.execute();
        } catch (Exception e) {
            rentTransaction3.rollback();
        }

        customer2.printRentedBuildings();

        System.out.println("--------------------------");
        rentalManager.printRentalMangerDetails();
        System.out.println("--------------------------");




    }
}
