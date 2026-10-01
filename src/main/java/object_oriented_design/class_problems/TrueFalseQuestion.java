package object_oriented_design.class_problems;

public class TrueFalseQuestion extends Question {

    private boolean correctAnswer;

    public TrueFalseQuestion(String questionId, String prompt, int points, boolean correctAnswer) {
        super(questionId, prompt, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String studentAnswer) {
        if (studentAnswer == null) {
            return false;
        }
        return Boolean.parseBoolean(studentAnswer.trim()) == correctAnswer;
    }
}
