package advanced_oop.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class CampusVehiclePassSystem {

    private Map<String, Vehicle> vehicles = new LinkedHashMap<>();

    public void registerPass(String vehicleType, String passNumber, String ownerName) {
        Vehicle vehicle;
        if (vehicleType.equalsIgnoreCase("Bike")) {
            vehicle = new Bike(passNumber, ownerName);
        } else if (vehicleType.equalsIgnoreCase("Car")) {
            vehicle = new Car(passNumber, ownerName);
        } else if (vehicleType.equalsIgnoreCase("EBike") || vehicleType.equalsIgnoreCase("E-Bike")) {
            vehicle = new EBike(passNumber, ownerName);
        } else if (vehicleType.equalsIgnoreCase("ECar") || vehicleType.equalsIgnoreCase("E-Car")) {
            vehicle = new ECar(passNumber, ownerName);
        } else {
            return;
        }
        vehicles.put(passNumber, vehicle);
        System.out.println(vehicle.getPassNumber() + " (" + vehicle.getType() + ") pass fee " + vehicle.getPassFee());
    }

    public void chargeBay(String passNumber) {
        Vehicle vehicle = vehicles.get(passNumber);
        if (vehicle == null) {
            System.out.println(passNumber + " rejected: vehicle not registered");
        } else if (vehicle instanceof Chargeable) {
            System.out.println(vehicle.getPassNumber() + " charging bay allotted");
        } else {
            System.out.println(vehicle.getPassNumber() + " rejected: charging unsupported");
        }
    }

    public void executeCommand(String commandLine) {
        if (commandLine == null || commandLine.trim().isEmpty()) {
            return;
        }
        String[] parts = commandLine.trim().split("\\s+");
        String op = parts[0];
        if (op.equalsIgnoreCase("PASS")) {
            registerPass(parts[1], parts[2], parts[3]);
        } else if (op.equalsIgnoreCase("CHARGE")) {
            chargeBay(parts[1]);
        }
    }

    public static void main(String[] args) {
        CampusVehiclePassSystem system = new CampusVehiclePassSystem();
        system.executeCommand("PASS Bike KA01 Asha");
        system.executeCommand("PASS ECar KA02 Ravi");
        system.executeCommand("CHARGE KA02");
        system.executeCommand("CHARGE KA01");
    }
}
