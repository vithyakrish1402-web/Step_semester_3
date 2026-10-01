package object_oriented_design.class_problems;

import java.util.HashMap;
import java.util.Map;

public class VehicleRentalSystem {

    private static int rentalCount = 0;
    private Map<String, Rental> activeRentals = new HashMap<>();

    public Rental rentVehicle(Customer customer, Vehicle vehicle, int days) {
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getModel() + " is currently unavailable.");
            return null;
        }
        vehicle.setAvailable(false);
        Rental rental = new Rental("R-" + (++rentalCount), customer, vehicle, days);
        activeRentals.put(vehicle.getVehicleId(), rental);
        System.out.println(vehicle.getModel() + " rented successfully by " + customer.getName() + ". Rental charge: $" + String.format("%.1f", rental.getRentalCharge()) + ".");
        return rental;
    }

    public void returnVehicle(Customer customer, Vehicle vehicle) {
        Rental rental = activeRentals.get(vehicle.getVehicleId());
        if (rental != null && rental.isActive()) {
            rental.completeRental();
            activeRentals.remove(vehicle.getVehicleId());
            System.out.println(vehicle.getModel() + " returned by " + customer.getName() + ".");
        }
    }

    public static void main(String[] args) {
        Customer c1 = new Customer("Customer 1");
        Customer c2 = new Customer("Customer 2");
        Customer c3 = new Customer("Customer 3");

        Vehicle sedanA = new Sedan("Sedan A");
        Vehicle suvB = new SUV("SUV B");

        VehicleRentalSystem system = new VehicleRentalSystem();
        system.rentVehicle(c1, sedanA, 3);
        system.rentVehicle(c2, sedanA, 2);
        system.returnVehicle(c1, sedanA);
        system.rentVehicle(c3, suvB, 5);
    }
}
