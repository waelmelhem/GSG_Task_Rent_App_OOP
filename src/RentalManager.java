import java.util.ArrayList;
import java.util.List;

class RentalManager implements Subject {
    private static RentalManager instance;
    private List<Building> availableBuildings;
    private List<Contract> contracts;
    private List<Observer> observers;

    private RentalManager() {
        availableBuildings = new ArrayList<>();
        contracts = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static RentalManager getInstance() {
        if (instance == null) {
            instance = new RentalManager();
        }
        return instance;
    }

    public void addBuilding(Building building) {
        availableBuildings.add(building);
        notifyObservers("New building available for rent: " + building.getName());
    }
    public void addBuildingWithoutObserve(Building building) {
        System.out.println(building.getName()+" Available to rent");
        availableBuildings.add(building);
    }

    public void removeBuilding(Building building) {
        if(availableBuildings.remove(building)) System.out.println(building.getName()+" unavailable to rent");
    }

    public List<Building> getAvailableBuildings() {
        return availableBuildings;
    }

    public void addContract(Contract contract) {
        contracts.add(contract);
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public boolean cancelContract(Contract contract) {
        return contracts.remove(contract);
    }

    public void printRentalMangerDetails(){
        System.out.println("Available buildings:");
        for(Building building : availableBuildings){
            System.out.println(building.getName());
            System.out.println("-----");
        }
        System.out.println("------------------------");
        System.out.println("Contracts:");
        for(Contract contract : contracts){
            System.out.println(contract.generateContractDetails());
            System.out.println("-----");
        }
    }
}
