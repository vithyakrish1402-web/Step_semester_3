package object_oriented_design.class_problems;

public class ShortAnswerQuestion extends Question {

    private String expectedAnswer;

    public ShortAnswerQuestion(String questionId, String prompt, int points, String expectedAnswer) {
        super(questionId, prompt, points);
        this.expectedAnswer = expectedAnswer;
    }

    @Override
    public boolean evaluate(String studentAnswer) {
        if (expectedAnswer == null || studentAnswer == null) {
            return false;
        }
        return expectedAnswer.trim().equalsIgnoreCase(studentAnswer.trim());
    }
}
