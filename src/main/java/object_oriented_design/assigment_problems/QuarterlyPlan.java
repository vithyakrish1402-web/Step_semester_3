package object_oriented_design.assigment_problems;

public class QuarterlyPlan implements MembershipPlan {

    @Override
    public String getPlanName() {
        return "Quarterly";
    }

    @Override
    public int getDurationMonths() {
        return 3;
    }

    @Override
    public double calculateFee(double baseMonthlyRate) {
        return baseMonthlyRate * 3 * 0.90;
    }
}
