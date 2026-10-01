package object_oriented_design.assigment_problems;

public class Submission {

    private Student student;
    private Assignment assignment;
    private int submissionDay;
    private SubmissionStatus status;
    private double finalMarks;

    public Submission(Student student, Assignment assignment, int submissionDay) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDay = submissionDay;
        this.status = SubmissionStatus.SUBMITTED;
    }

    public Student getStudent() {
        return student;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public int getSubmissionDay() {
        return submissionDay;
    }

    public SubmissionStatus getStatus() {
        return status;
    }

    public int getDaysLate() {
        return Math.max(0, submissionDay - assignment.getDueDay());
    }

    public void grade(double rawMarks) {
        int daysLate = getDaysLate();
        double penalty = assignment.calculatePenalty(daysLate, rawMarks);
        this.finalMarks = Math.max(0.0, rawMarks - penalty);
        this.status = SubmissionStatus.GRADED;

        if (daysLate > 0) {
            int totalPenaltyPercent = daysLate * assignment.getPenaltyPercentagePerDay();
            System.out.printf("%s graded: %d/%d after %d%% late penalty. Status: Graded.%n",
                    student.getName(), (int) Math.round(finalMarks), assignment.getMaxMarks(), totalPenaltyPercent);
        } else {
            System.out.printf("%s graded: %d/%d. Status: Graded.%n",
                    student.getName(), (int) Math.round(finalMarks), assignment.getMaxMarks());
        }
    }
}
