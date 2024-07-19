import java.util.ArrayList;
import java.util.List;

class Customer implements Observer {
    private String name;
    private String email;
    private List<Building> rentedBuildings;
    private PaymentStrategy paymentStrategy;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.rentedBuildings = new ArrayList<>();
    }

    public void rentBuilding(Building building) {
        rentedBuildings.add(building);
    }

    public List<Building> getRentedBuildings() {
        return rentedBuildings;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("No payment strategy set.");
        }
    }

    public boolean hasPaymentStrategy(){
        return paymentStrategy != null;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }

    public boolean removeRentedBuilding(Building building) {
        return rentedBuildings.remove(building);
    }

    public void printRentedBuildings() {
        System.out.println(this.getName()+ " has " + rentedBuildings.size() + " rented buildings:");
        for (Building building : rentedBuildings) {
            System.out.println("*"+building);
        }
    }

}
