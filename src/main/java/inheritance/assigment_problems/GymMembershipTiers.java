package inheritance.assigment_problems;

public class GymMembershipTiers {

    public static void main(String[] args) {
        PremiumMember premiumMember = new PremiumMember("MEM2", 2000, "Coach Riya");
        EliteMember eliteMember = new EliteMember("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMember groupClassMember = new GroupClassMember("MEM4", 1500, "Zumba");

        premiumMember.attendSession();
        premiumMember.attendSession();
        premiumMember.attendSession();

        eliteMember.attendSession();
        eliteMember.attendSession();

        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();
        groupClassMember.attendSession();

        System.out.println(GymMember.classifyGeneration(eliteMember));
        System.out.println(GymMember.classifyGeneration(groupClassMember));

        GymMember[] members = {premiumMember, eliteMember, groupClassMember};
        System.out.println(GymMember.getTotalSessionsAttended(members));
    }
}
