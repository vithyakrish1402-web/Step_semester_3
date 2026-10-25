package advanced_oop.class_problems;

public abstract class Staff {

    private String name;
    private String type;

    public Staff(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public abstract int calculatePay();
}
