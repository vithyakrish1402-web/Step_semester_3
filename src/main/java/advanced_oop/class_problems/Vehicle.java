package advanced_oop.class_problems;

public abstract class Vehicle {

    private String passNumber;
    private String ownerName;
    private String type;

    public Vehicle(String passNumber, String ownerName, String type) {
        this.passNumber = passNumber;
        this.ownerName = ownerName;
        this.type = type;
    }

    public String getPassNumber() {
        return passNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getType() {
        return type;
    }

    public abstract int getPassFee();
}
