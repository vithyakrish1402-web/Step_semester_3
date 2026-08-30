package string.assigment_problems;

public class ExamHallSeatDuplicationChecker {


    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("Seat list is empty.");
            return;
        }

        boolean foundDuplicate = false;

        boolean[] alreadyReported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyReported[i]) {
                continue;
            }

            boolean isCurrentDuplicate = false;

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isCurrentDuplicate = true;
                    alreadyReported[j] = true;
                }
            }

            if (isCurrentDuplicate) {
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                foundDuplicate = true;
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Examination Cell: Seat Duplication Checker ===");


        int[] hall1 = {101, 102, 103, 102, 105};
        System.out.print("Test 1 {101, 102, 103, 102, 105}: ");
        checkDuplicateSeats(hall1);


        int[] hall2 = {101, 102, 103, 104, 105};
        System.out.print("Test 2 {101, 102, 103, 104, 105}: ");
        checkDuplicateSeats(hall2);


        int[] hall3 = {201, 202, 201, 203, 204, 203};
        System.out.println("\nTest 3 {201, 202, 201, 203, 204, 203}:");
        checkDuplicateSeats(hall3);
    }
}
