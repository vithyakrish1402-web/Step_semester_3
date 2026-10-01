package object_oriented_design.class_problems;

public class Rental {

    private String rentalId;
    private Customer customer;
    private Vehicle vehicle;
    private int days;
    private double rentalCharge;
    private boolean active;

    public Rental(String rentalId, Customer customer, Vehicle vehicle, int days) {
        this.rentalId = rentalId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
        this.rentalCharge = vehicle.calculateRentalCharge(days);
        this.active = true;
    }

    public String getRentalId() {
        return rentalId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getDays() {
        return days;
    }

    public double getRentalCharge() {
        return rentalCharge;
    }

    public boolean isActive() {
        return active;
    }

    public void completeRental() {
        this.active = false;
        this.vehicle.setAvailable(true);
    }
}
