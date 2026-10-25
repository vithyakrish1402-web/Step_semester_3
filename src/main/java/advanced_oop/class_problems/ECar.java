package advanced_oop.class_problems;

public class ECar extends Vehicle implements Chargeable {

    public ECar(String passNumber, String ownerName) {
        super(passNumber, ownerName, "ECar");
    }

    @Override
    public int getPassFee() {
        return 1000;
    }

    @Override
    public boolean isElectric() {
        return true;
    }
}
