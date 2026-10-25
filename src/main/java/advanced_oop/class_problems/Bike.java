package advanced_oop.class_problems;

public class Bike extends Vehicle {

    public Bike(String passNumber, String ownerName) {
        super(passNumber, ownerName, "Bike");
    }

    @Override
    public int getPassFee() {
        return 300;
    }
}
