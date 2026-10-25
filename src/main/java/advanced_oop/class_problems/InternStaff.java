package advanced_oop.class_problems;

public class InternStaff extends Staff {

    private int stipend;

    public InternStaff(String name, int stipend) {
        super(name, "Intern");
        this.stipend = stipend;
    }

    @Override
    public int calculatePay() {
        return stipend;
    }
}
