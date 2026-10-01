package object_oriented_design.class_problems;

public class Suite extends Room {

    private double ratePerNight = 350.0;

    public Suite(String roomNumber) {
        super(roomNumber, "Suite " + roomNumber);
    }

    @Override
    public double calculatePrice(int days) {
        return ratePerNight * days;
    }
}
