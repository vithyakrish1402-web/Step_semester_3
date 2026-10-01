package abstract_interfaces.assigment_problems;

public class SkylineDeliveryFleet {

    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            return ((Trackable) o).getLocation();
        }
        return "Tracking not available";
    }

    public static void main(String[] args) {
        DeliveryDrone d = new DeliveryDrone("DR-1");
        System.out.println(getLocationIfTrackable(d));

        ScoutDrone s = new ScoutDrone("SC-1");
        System.out.println(getLocationIfTrackable(s));

        GroundRobot g = new GroundRobot("GR-1");
        System.out.println(getLocationIfTrackable(g));
    }
}
