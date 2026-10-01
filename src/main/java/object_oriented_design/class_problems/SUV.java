package object_oriented_design.class_problems;

public class SUV extends Vehicle {

    private double dailyRate;

    public SUV(String model) {
        super(model, model);
        this.dailyRate = 80.0;
    }

    public SUV(String vehicleId, String model, double dailyRate) {
        super(vehicleId, model);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCharge(int days) {
        return dailyRate * days;
    }
}
