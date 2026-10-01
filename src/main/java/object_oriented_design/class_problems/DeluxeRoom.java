package object_oriented_design.class_problems;

public class DeluxeRoom extends Room {

    private double ratePerNight = 200.0;

    public DeluxeRoom(String roomNumber) {
        super(roomNumber, "Deluxe Room " + roomNumber);
    }

    @Override
    public double calculatePrice(int days) {
        return ratePerNight * days;
    }
}
