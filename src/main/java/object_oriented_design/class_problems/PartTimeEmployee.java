package object_oriented_design.class_problems;

public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name) {
        super(name);
    }

    public PartTimeEmployee(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean validateLeavePolicy(int days) {
        return days <= 15;
    }
}
