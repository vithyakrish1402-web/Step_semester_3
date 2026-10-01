package object_oriented_design.assigment_problems;

public class FitZoneMembershipDesk {

    private static final double BASE_MONTHLY_RATE = 1000.0;

    public Membership buyMembership(Member member, MembershipPlan plan) {
        return new Membership(member, plan, BASE_MONTHLY_RATE);
    }

    public static void main(String[] args) {
        FitZoneMembershipDesk desk = new FitZoneMembershipDesk();

        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        Membership ashaMembership = desk.buyMembership(asha, new QuarterlyPlan());
        Membership raviMembership = desk.buyMembership(ravi, new MonthlyPlan());

        ashaMembership.checkIn();
        ashaMembership.freeze();
        ashaMembership.checkIn();

        raviMembership.expire();
        raviMembership.freeze();
    }
}
