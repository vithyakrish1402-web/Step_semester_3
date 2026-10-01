package object_oriented_design.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class Booking {

    private Customer customer;
    private Show show;
    private List<Seat> seats = new ArrayList<>();
    private boolean active;

    public Booking(Customer customer, Show show, List<Seat> seats) {
        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>(seats);
        this.active = true;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public boolean isActive() {
        return active;
    }

    public double calculateTotal() {
        double total = 0;
        for (Seat seat : seats) {
            total += seat.getPrice();
        }
        return total;
    }

    public String getSeatsSummary() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seats.size(); i++) {
            sb.append(seats.get(i).getSeatNumber());
            if (i < seats.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void cancel() {
        this.active = false;
        show.releaseSeats(seats);
    }
}
