package inheritance.class_problems;

public class BatchEnrollmentValidator {

    public static void main(String[] args) {
        try {
            new LibraryMember("LB1", 3);
        } catch (IllegalArgumentException e) {
            System.out.println("new LibraryMember(\"LB1\", 3) construction rejected");
        }

        StudentMember s = new StudentMember("STU10", 3, "CSE");
        s.borrowBook();
        s.borrowBook();
        System.out.println(s.getBooksBorrowed());

        String[] memberIds = {"STU1", "LB1", "STU2", " ", "STU3"};
        System.out.println(LibraryMember.enrollBatch(memberIds, 3));
    }
}
