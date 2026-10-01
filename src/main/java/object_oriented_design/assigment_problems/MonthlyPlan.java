package object_oriented_design.assigment_problems;

public class MonthlyPlan implements MembershipPlan {

    @Override
    public String getPlanName() {
        return "Monthly";
    }

    @Override
    public int getDurationMonths() {
        return 1;
    }

    @Override
    public double calculateFee(double baseMonthlyRate) {
        return baseMonthlyRate * 1.0;
    }
}
