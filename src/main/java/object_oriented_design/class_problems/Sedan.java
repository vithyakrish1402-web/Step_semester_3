package object_oriented_design.class_problems;

public class Sedan extends Vehicle {

    private double dailyRate;

    public Sedan(String model) {
        super(model, model);
        this.dailyRate = 50.0;
    }

    public Sedan(String vehicleId, String model, double dailyRate) {
        super(vehicleId, model);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCharge(int days) {
        return dailyRate * days;
    }
}
