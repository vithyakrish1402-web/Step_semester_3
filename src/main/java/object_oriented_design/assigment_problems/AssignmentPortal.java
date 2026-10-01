package object_oriented_design.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class AssignmentPortal {

    private Map<String, Submission> submissions = new HashMap<>();

    public Submission submitAssignment(Student student, Assignment assignment, int submissionDay) {
        String key = student.getName() + ":" + assignment.getTitle();
        Submission existing = submissions.get(key);
        if (existing != null && existing.getStatus() == SubmissionStatus.GRADED) {
            System.out.println("Cannot resubmit: '" + assignment.getTitle() + "' has already been graded.");
            return null;
        }

        Submission submission = new Submission(student, assignment, submissionDay);
        submissions.put(key, submission);

        int daysLate = submission.getDaysLate();
        if (daysLate == 0) {
            System.out.println(student.getName() + "'s submission for '" + assignment.getTitle() + "' received (on time). Status: Submitted.");
        } else {
            System.out.println(student.getName() + "'s submission for '" + assignment.getTitle() + "' received (" + daysLate + " days late). Status: Submitted.");
        }
        return submission;
    }

    public void gradeSubmission(Submission submission, double rawMarks) {
        if (submission != null) {
            submission.grade(rawMarks);
        }
    }

    public static void main(String[] args) {
        AssignmentPortal portal = new AssignmentPortal();

        Assignment linkedListLab = new CodingAssignment("Linked List Lab", 50, 10);
        Assignment designEssay = new WrittenAssignment("Design Essay", 50, 12);

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Submission ashaSub = portal.submitAssignment(asha, linkedListLab, 10);
        Submission raviSub = portal.submitAssignment(ravi, designEssay, 14);

        portal.gradeSubmission(ashaSub, 45);
        portal.gradeSubmission(raviSub, 40);

        portal.submitAssignment(asha, linkedListLab, 15);
    }
}
