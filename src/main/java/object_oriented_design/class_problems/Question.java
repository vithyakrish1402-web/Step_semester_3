package object_oriented_design.class_problems;

public abstract class Question {

    private String questionId;
    private String prompt;
    private int points;

    public Question(String questionId, String prompt, int points) {
        this.questionId = questionId;
        this.prompt = prompt;
        this.points = points;
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getPrompt() {
        return prompt;
    }

    public int getPoints() {
        return points;
    }

    public abstract boolean evaluate(String studentAnswer);
}
