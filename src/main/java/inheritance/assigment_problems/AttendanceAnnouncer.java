package inheritance.assigment_problems;

public class AttendanceAnnouncer {

    public static void main(String[] args) {
        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember("MEM7", 2000, "Coach Riya")
        };
        System.out.println(GymMember.batchPrint(members));
    }
}
