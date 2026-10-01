package object_oriented_design.class_problems;

import java.util.ArrayList;
import java.util.List;

public class Examination {

    private String examId;
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Examination(String title) {
        this.examId = title;
        this.title = title;
    }

    public Examination(String examId, String title) {
        this.examId = examId;
        this.title = title;
    }

    public String getExamId() {
        return examId;
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
