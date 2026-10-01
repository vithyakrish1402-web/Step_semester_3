package object_oriented_design.class_problems;

public class Contractor extends Employee {

    public Contractor(String name) {
        super(name);
    }

    public Contractor(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean validateLeavePolicy(int days) {
        return days <= 5;
    }
}
