package object_oriented_design.class_problems;

public class Student {

    private String studentId;
    private String name;

    public Student(String name) {
        this.studentId = name;
        this.name = name;
    }

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}
