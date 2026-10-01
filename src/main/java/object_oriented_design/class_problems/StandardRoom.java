package object_oriented_design.class_problems;

public class StandardRoom extends Room {

    private double ratePerNight = 100.0;

    public StandardRoom(String roomNumber) {
        super(roomNumber, "Standard Room " + roomNumber);
    }

    @Override
    public double calculatePrice(int days) {
        return ratePerNight * days;
    }
}
