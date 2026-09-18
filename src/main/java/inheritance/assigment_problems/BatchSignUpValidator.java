package inheritance.assigment_problems;

public class BatchSignUpValidator {

    public static void main(String[] args) {
        try {
            new GymMember("GM1", 1000);
        } catch (IllegalArgumentException e) {
            System.out.println("new GymMember(\"GM1\", 1000) construction rejected");
        }

        PremiumMember p = new PremiumMember("MEM01", 2000, "Coach Riya");
        p.attendSession();
        p.attendSession();
        System.out.println(p.getSessionsAttended());

        String[] memberIds = {"MEM1", "GM1", "MEM2", " ", "MEM3"};
        System.out.println(GymMember.signUpBatch(memberIds, 1000));
    }
}
