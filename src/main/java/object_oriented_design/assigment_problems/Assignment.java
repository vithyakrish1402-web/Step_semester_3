package object_oriented_design.assigment_problems;

public abstract class Assignment {

    private String title;
    private int maxMarks;
    private int dueDay;

    public Assignment(String title, int maxMarks, int dueDay) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDay = dueDay;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public int getDueDay() {
        return dueDay;
    }

    public abstract int getPenaltyPercentagePerDay();

    public double calculatePenalty(int daysLate, double rawMarks) {
        if (daysLate <= 0) {
            return 0.0;
        }
        double penaltyPercent = (daysLate * getPenaltyPercentagePerDay()) / 100.0;
        return rawMarks * penaltyPercent;
    }
}
