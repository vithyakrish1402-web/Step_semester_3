package object_oriented_design.class_problems;

public abstract class Vehicle {

    private String vehicleId;
    private String model;
    private boolean available = true;

    public Vehicle(String vehicleId, String model) {
        this.vehicleId = vehicleId;
        this.model = model;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRentalCharge(int days);
}
