package object_oriented_design.assigment_problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Show {

    private String showName;
    private Set<String> bookedSeats = new HashSet<>();

    public Show(String showName) {
        this.showName = showName;
    }

    public String getShowName() {
        return showName;
    }

    public boolean isSeatBooked(String seatNumber) {
        return bookedSeats.contains(seatNumber);
    }

    public void bookSeat(String seatNumber) {
        bookedSeats.add(seatNumber);
    }

    public void releaseSeat(String seatNumber) {
        bookedSeats.remove(seatNumber);
    }

    public void releaseSeats(List<Seat> seats) {
        for (Seat seat : seats) {
            bookedSeats.remove(seat.getSeatNumber());
        }
    }
}
