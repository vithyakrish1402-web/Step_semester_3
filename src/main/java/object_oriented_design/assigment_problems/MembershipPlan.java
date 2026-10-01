package object_oriented_design.assigment_problems;

public interface MembershipPlan {
    String getPlanName();
    int getDurationMonths();
    double calculateFee(double baseMonthlyRate);
}
