package advanced_oop.class_problems;

public class PartTimeStaff extends Staff {

    private int hours;
    private int rate;

    public PartTimeStaff(String name, int hours, int rate) {
        super(name, "PartTime");
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public int calculatePay() {
        return hours * rate;
    }
}
