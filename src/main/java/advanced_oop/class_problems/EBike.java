package advanced_oop.class_problems;

public class EBike extends Vehicle implements Chargeable {

    public EBike(String passNumber, String ownerName) {
        super(passNumber, ownerName, "EBike");
    }

    @Override
    public int getPassFee() {
        return 300;
    }

    @Override
    public boolean isElectric() {
        return true;
    }
}
