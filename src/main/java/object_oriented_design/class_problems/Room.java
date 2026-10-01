package object_oriented_design.class_problems;

import java.util.ArrayList;
import java.util.List;

public abstract class Room {

    private String roomNumber;
    private String roomName;
    private List<Reservation> activeReservations = new ArrayList<>();

    public Room(String roomNumber, String roomName) {
        this.roomNumber = roomNumber;
        this.roomName = roomName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean isAvailable(DateRange period) {
        for (Reservation r : activeReservations) {
            if (r.isActive() && r.getPeriod().overlaps(period)) {
                return false;
            }
        }
        return true;
    }

    public void addReservation(Reservation reservation) {
        activeReservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        activeReservations.remove(reservation);
    }

    public abstract double calculatePrice(int days);
}
