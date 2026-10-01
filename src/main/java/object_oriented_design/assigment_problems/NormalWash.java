package object_oriented_design.assigment_problems;

public class NormalWash implements WashType {

    @Override
    public String getName() {
        return "Normal";
    }

    @Override
    public int getDurationMinutes() {
        return 45;
    }

    @Override
    public double getCharge() {
        return 30.00;
    }
}
