package object_oriented_design.class_problems;

public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name) {
        super(name);
    }

    public FullTimeEmployee(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean validateLeavePolicy(int days) {
        return days <= 30;
    }
}
