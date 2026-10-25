package advanced_oop.class_problems;

public class Payslip {

    private String name;
    private String type;
    private int pay;

    public Payslip(String name, String type, int pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPay() {
        return pay;
    }

    @Override
    public String toString() {
        return "Payslip[name=" + name + ", type=" + type + ", pay=" + pay + "]";
    }
}
