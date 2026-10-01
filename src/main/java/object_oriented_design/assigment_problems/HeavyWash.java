package object_oriented_design.assigment_problems;

public class HeavyWash implements WashType {

    @Override
    public String getName() {
        return "Heavy";
    }

    @Override
    public int getDurationMinutes() {
        return 60;
    }

    @Override
    public double getCharge() {
        return 45.00;
    }
}
