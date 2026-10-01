package object_oriented_design.assigment_problems;

import java.util.Arrays;
import java.util.List;

public class CampusTicketCounter {

    public Booking bookSeats(Customer customer, Show show, List<Seat> seats) {
        if (seats == null || seats.isEmpty() || seats.size() > 6) {
            return null;
        }

        for (Seat s : seats) {
            if (show.isSeatBooked(s.getSeatNumber())) {
                System.out.println("Seat " + s.getSeatNumber() + " is already booked for this show.");
                return null;
            }
        }

        for (Seat s : seats) {
            show.bookSeat(s.getSeatNumber());
        }

        Booking booking = new Booking(customer, show, seats);
        System.out.printf("Booking confirmed for %s: %s. Total: \u20B9%.2f.%n",
                customer.getName(), booking.getSeatsSummary(), booking.calculateTotal());
        return booking;
    }

    public void cancelBooking(Booking booking, boolean beforeShowStarts) {
        if (!beforeShowStarts) {
            System.out.println("Cannot cancel booking after show has started.");
            return;
        }
        if (booking != null && booking.isActive()) {
            String summary = booking.getSeatsSummary();
            booking.cancel();
            System.out.println(booking.getCustomer().getName() + "'s booking cancelled. Seats " + summary + " released.");
        }
    }

    public static void main(String[] args) {
        CampusTicketCounter counter = new CampusTicketCounter();
        Show show7PM = new Show("7 PM show");

        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Seat a1 = new RegularSeat("A1");
        Seat a2 = new RegularSeat("A2");
        Seat f5 = new PremiumSeat("F5");
        Seat r1 = new ReclinerSeat("R1");

        Booking ashaBooking = counter.bookSeats(asha, show7PM, Arrays.asList(a1, a2, f5));
        counter.bookSeats(ravi, show7PM, Arrays.asList(new RegularSeat("A2")));
        counter.bookSeats(ravi, show7PM, Arrays.asList(r1));
        counter.cancelBooking(ashaBooking, true);
        counter.bookSeats(neha, show7PM, Arrays.asList(new RegularSeat("A2")));
    }
}
