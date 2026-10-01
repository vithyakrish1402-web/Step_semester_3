package object_oriented_design.class_problems;

public abstract class Employee {

    private String id;
    private String name;

    public Employee(String name) {
        this.id = name;
        this.name = name;
    }

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract boolean validateLeavePolicy(int days);
}
