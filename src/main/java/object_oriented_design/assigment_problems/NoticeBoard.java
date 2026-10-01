package object_oriented_design.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class NoticeBoard {

    private List<Student> students = new ArrayList<>();

    public void registerStudent(Student student) {
        students.add(student);
    }

    public boolean postNotice(Notice notice) {
        if (notice.getTitle() == null || notice.getTitle().trim().isEmpty()) {
            System.out.println("Cannot post notice: Notice title is required.");
            return false;
        }

        List<String> targetDepts = notice.getTargetDepartments();
        if (targetDepts == null || targetDepts.isEmpty()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return false;
        }

        String deptListStr = String.join(", ", targetDepts);
        System.out.println("Notice '" + notice.getTitle() + "' posted to " + deptListStr + ".");

        for (Student student : students) {
            if (targetDepts.contains(student.getDepartment())) {
                for (NotificationChannel channel : student.getPreferredChannels()) {
                    channel.send(student.getName(), notice.getTitle());
                }
            }
        }
        return true;
    }
}
