package object_oriented_design.class_problems;

public class HotelBookingSystem {

    private static int resCounter = 0;

    public boolean checkAvailability(Room room, DateRange period, String displayRange) {
        boolean available = room.isAvailable(period);
        if (available) {
            System.out.println(room.getRoomName() + " is available from " + displayRange + ".");
        } else {
            System.out.println(room.getRoomName() + " is not available from " + displayRange + ".");
        }
        return available;
    }

    public Reservation reserveRoom(Customer customer, Room room, DateRange period, String displayRange) {
        if (!room.isAvailable(period)) {
            System.out.println(room.getRoomName() + " is not available from " + displayRange + ".");
            return null;
        }
        double price = room.calculatePrice(period.getDays());
        Reservation res = new Reservation("RES-" + (++resCounter), customer, room, period, price, period.getStartDay());
        room.addReservation(res);
        System.out.println("Reservation confirmed for " + customer.getName() + ", " + room.getRoomName() + " (" + period.getLabel() + "). Price: $" + String.format("%.0f", price) + ".");
        return res;
    }

    public static void main(String[] args) {
        Customer custA = new Customer("Customer A");
        Customer custB = new Customer("Customer B");
        Customer custC = new Customer("Customer C");

        Room room101 = new StandardRoom("101");
        Room room201 = new DeluxeRoom("201");

        HotelBookingSystem system = new HotelBookingSystem();
        DateRange jan1_5 = new DateRange("Jan 1-5", 1, 5);
        DateRange jan3_7 = new DateRange("Jan 3-7", 3, 7);
        DateRange feb10_12 = new DateRange("Feb 10-12", 41, 43);

        system.checkAvailability(room101, jan1_5, "Jan 1 to Jan 5");
        Reservation resA = system.reserveRoom(custA, room101, jan1_5, "Jan 1 to Jan 5");
        system.reserveRoom(custB, room101, jan3_7, "Jan 3 to Jan 7");
        if (resA != null) {
            resA.cancel(0);
        }
        system.reserveRoom(custC, room201, feb10_12, "Feb 10 to Feb 12");
    }
}
