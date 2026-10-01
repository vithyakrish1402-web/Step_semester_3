package object_oriented_design.class_problems;

public class Customer {

    private String id;
    private String name;

    public Customer(String name) {
        this.id = name;
        this.name = name;
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
