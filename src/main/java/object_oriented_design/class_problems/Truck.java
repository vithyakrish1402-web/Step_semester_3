package object_oriented_design.class_problems;

public class Truck extends Vehicle {

    private double dailyRate;

    public Truck(String model) {
        super(model, model);
        this.dailyRate = 100.0;
    }

    public Truck(String vehicleId, String model, double dailyRate) {
        super(vehicleId, model);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCharge(int days) {
        return dailyRate * days;
    }
}
