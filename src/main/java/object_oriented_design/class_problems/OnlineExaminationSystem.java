package object_oriented_design.class_problems;

public class OnlineExaminationSystem {

    public static void main(String[] args) {
        Student student1 = new Student("Student 1");
        Examination examA = new Examination("Exam A");
        examA.addQuestion(new MultipleChoiceQuestion("Question 1", "Select correct option", 5, "C"));
        examA.addQuestion(new TrueFalseQuestion("Question 2", "Select True or False", 5, false));

        Attempt attempt = new Attempt(student1, examA);
        attempt.recordAnswer("Question 1", "C");
        attempt.recordAnswer("Question 2", "True");
        attempt.submit();
        attempt.recordAnswer("Question 1", "B");
    }
}
