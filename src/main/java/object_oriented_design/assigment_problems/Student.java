package object_oriented_design.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String department;
    private List<NotificationChannel> preferredChannels = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public List<NotificationChannel> getPreferredChannels() {
        return preferredChannels;
    }

    public void addPreferredChannel(NotificationChannel channel) {
        preferredChannels.add(channel);
    }
}
