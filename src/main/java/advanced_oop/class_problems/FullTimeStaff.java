package advanced_oop.class_problems;

public class FullTimeStaff extends Staff {

    private int salary;

    public FullTimeStaff(String name, int salary) {
        super(name, "FullTime");
        this.salary = salary;
    }

    @Override
    public int calculatePay() {
        return salary;
    }
}
