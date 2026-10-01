package object_oriented_design.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class Notice {

    private String title;
    private List<String> targetDepartments = new ArrayList<>();

    public Notice(String title, List<String> targetDepartments) {
        this.title = title;
        if (targetDepartments != null) {
            this.targetDepartments = new ArrayList<>(targetDepartments);
        }
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTargetDepartments() {
        return targetDepartments;
    }
}
