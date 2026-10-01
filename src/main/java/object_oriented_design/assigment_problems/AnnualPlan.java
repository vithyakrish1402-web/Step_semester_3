package object_oriented_design.assigment_problems;

public class AnnualPlan implements MembershipPlan {

    @Override
    public String getPlanName() {
        return "Annual";
    }

    @Override
    public int getDurationMonths() {
        return 12;
    }

    @Override
    public double calculateFee(double baseMonthlyRate) {
        return baseMonthlyRate * 12 * 0.75;
    }
}
