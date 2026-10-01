package abstract_interfaces.assigment_problems;

public class ScoutDrone extends Drone {

    public ScoutDrone(String id) {
        super(id);
    }

    @Override
    public String fly() {
        return "ScoutDrone " + id + " flying";
    }
}
