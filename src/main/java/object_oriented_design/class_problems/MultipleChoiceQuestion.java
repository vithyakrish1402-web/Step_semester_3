package object_oriented_design.class_problems;

public class MultipleChoiceQuestion extends Question {

    private String correctAnswer;

    public MultipleChoiceQuestion(String questionId, String prompt, int points, String correctAnswer) {
        super(questionId, prompt, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String studentAnswer) {
        return correctAnswer != null && correctAnswer.equalsIgnoreCase(studentAnswer);
    }
}
