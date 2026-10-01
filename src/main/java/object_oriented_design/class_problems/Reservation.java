package object_oriented_design.class_problems;

public class Reservation {

    private String reservationId;
    private Customer customer;
    private Room room;
    private DateRange period;
    private double price;
    private boolean active = true;
    private int deadlineDay;

    public Reservation(String reservationId, Customer customer, Room room, DateRange period, double price, int deadlineDay) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.period = period;
        this.price = price;
        this.deadlineDay = deadlineDay;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public DateRange getPeriod() {
        return period;
    }

    public double getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public boolean cancel(int currentDay) {
        if (!active) {
            return false;
        }
        if (currentDay > deadlineDay) {
            System.out.println("Cannot cancel reservation: deadline passed.");
            return false;
        }
        active = false;
        room.removeReservation(this);
        System.out.println("Reservation for " + customer.getName() + ", " + room.getRoomName() + " (" + period.getLabel() + ") cancelled successfully.");
        return true;
    }
}
