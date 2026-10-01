package object_oriented_design.assigment_problems;

public class Membership {

    private Member member;
    private MembershipPlan plan;
    private double fee;
    private MembershipStatus status;

    public Membership(Member member, MembershipPlan plan, double baseMonthlyRate) {
        this.member = member;
        this.plan = plan;
        this.fee = plan.calculateFee(baseMonthlyRate);
        this.status = MembershipStatus.ACTIVE;
        System.out.printf("%s membership created for %s. Fee: \u20B9%,.2f. Status: Active.%n",
                plan.getPlanName(), member.getName(), fee);
    }

    public Member getMember() {
        return member;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public double getFee() {
        return fee;
    }

    public MembershipStatus getStatus() {
        return status;
    }

    public void checkIn() {
        if (status == MembershipStatus.ACTIVE) {
            System.out.println(member.getName() + " checked in successfully.");
        } else if (status == MembershipStatus.FROZEN) {
            System.out.println("Check-in denied: " + member.getName() + "'s membership is Frozen.");
        } else {
            System.out.println("Check-in denied: " + member.getName() + "'s membership is Expired.");
        }
    }

    public void freeze() {
        if (status == MembershipStatus.EXPIRED) {
            System.out.println("Cannot freeze an Expired membership.");
            return;
        }
        this.status = MembershipStatus.FROZEN;
        System.out.println(member.getName() + "'s membership frozen. Status: Frozen.");
    }

    public void unfreeze() {
        if (status == MembershipStatus.EXPIRED) {
            System.out.println("Cannot unfreeze an Expired membership.");
            return;
        }
        this.status = MembershipStatus.ACTIVE;
        System.out.println(member.getName() + "'s membership unfrozen. Status: Active.");
    }

    public void expire() {
        this.status = MembershipStatus.EXPIRED;
        System.out.println(member.getName() + "'s membership expired. Status: Expired.");
    }
}
