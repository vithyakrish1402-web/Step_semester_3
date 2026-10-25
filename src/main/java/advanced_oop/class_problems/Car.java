package advanced_oop.class_problems;

public class Car extends Vehicle {

    public Car(String passNumber, String ownerName) {
        super(passNumber, ownerName, "Car");
    }

    @Override
    public int getPassFee() {
        return 1000;
    }
}
