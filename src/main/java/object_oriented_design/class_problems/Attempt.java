package object_oriented_design.class_problems;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Attempt {

    private Student student;
    private Examination examination;
    private Map<String, String> answers = new LinkedHashMap<>();
    private AttemptStatus status = AttemptStatus.IN_PROGRESS;

    public Attempt(Student student, Examination examination) {
        this.student = student;
        this.examination = examination;
        System.out.println(examination.getTitle() + " started by " + student.getName() + ".");
    }

    public Student getStudent() {
        return student;
    }

    public Examination getExamination() {
        return examination;
    }

    public AttemptStatus getStatus() {
        return status;
    }

    public void recordAnswer(String questionId, String answer) {
        if (status == AttemptStatus.SUBMITTED) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }
        answers.put(questionId, answer);
        System.out.println("Answer recorded for " + questionId + ".");
    }

    public void submit() {
        if (status == AttemptStatus.SUBMITTED) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }
        status = AttemptStatus.SUBMITTED;
        System.out.println(examination.getTitle() + " submitted by " + student.getName() + ".");

        int totalEarned = 0;
        int totalPossible = 0;
        StringBuilder sb = new StringBuilder("Result: ");
        List<Question> qList = examination.getQuestions();
        for (int i = 0; i < qList.size(); i++) {
            Question q = qList.get(i);
            totalPossible += q.getPoints();
            String ans = answers.get(q.getQuestionId());
            boolean correct = ans != null && q.evaluate(ans);
            int earned = correct ? q.getPoints() : 0;
            totalEarned += earned;

            sb.append(q.getQuestionId()).append(": ");
            if (correct) {
                sb.append("Correct (").append(earned).append(" points)");
            } else {
                sb.append("Incorrect (").append(earned).append(" points)");
            }

            if (i < qList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(". Total score: ").append(totalEarned).append("/").append(totalPossible).append(".");
        System.out.println(sb.toString());
    }
}
