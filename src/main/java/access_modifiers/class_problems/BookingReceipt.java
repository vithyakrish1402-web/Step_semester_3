package access_modifiers.class_problems;

import java.util.Arrays;

class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }

    public int getGroupSize() {
        return groupSize;
    }
}

public class BookingReceipt {

    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = (seatNumbers != null) ? seatNumbers.clone() : new String[0];
    }

    public String getBookingId() {
        return bookingId;
    }

    public String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        if (index < 0 || index >= seatNumbers.length) {
            return this;
        }
        String[] updatedSeats = seatNumbers.clone();
        updatedSeats[index] = newSeat;
        return new BookingReceipt(this.bookingId, updatedSeats);
    }

    public static String processNightlySettlement(BookingReceipt[] receipts) {
        if (receipts == null) {
            return "0 processed | 0 null skipped | 0 group | 0 individual";
        }

        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (int i = 0; i < receipts.length; i++) {
            BookingReceipt receipt = receipts[i];
            if (receipt == null) {
                nullSkipped++;
            } else {
                processed++;
                if (receipt instanceof GroupBookingReceipt) {
                    group++;
                } else {
                    individual++;
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println(b.getSeatNumbers()[0]);

        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println(Arrays.toString(b.getSeatNumbers()));
        System.out.println(Arrays.toString(updated.getSeatNumbers()));

        BookingReceipt[] batch = {
            new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
            null,
            new BookingReceipt("CH-3003", new String[]{"C1"})
        };
        System.out.println(processNightlySettlement(batch));
    }
}
