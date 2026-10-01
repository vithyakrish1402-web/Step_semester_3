package abstract_interfaces.assigment_problems;

public class DeliveryDrone extends Drone implements Trackable {

    public DeliveryDrone(String id) {
        super(id);
    }

    @Override
    public String fly() {
        return "DeliveryDrone " + id + " flying";
    }

    @Override
    public String getLocation() {
        return id + " at Sector 4";
    }
}
