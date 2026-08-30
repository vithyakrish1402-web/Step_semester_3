package oop_constructs.assigment_problems;

public class MembershipCard {

    private static String libraryName;
    private static String validUntil;
    private String studentName;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public static void main(String[] args) {
        String[] names = {"Ananya", "Rohan", "Priya", "Arjun", "Sneha"};

        for (int i = 0; i < names.length; i++) {
            MembershipCard card = new MembershipCard(names[i]);
            System.out.println("Membership card issued: " + card.getStudentName());
        }
    }
}
