package advanced_oop.class_problems;

import java.util.ArrayList;
import java.util.List;

public class PayrollRegisterSystem {

    private List<Staff> staffList = new ArrayList<>();

    public void addStaff(Staff staff) {
        staffList.add(staff);
    }

    public void generatePayrollReport() {
        int totalPay = 0;
        int maxPay = -1;
        String topEarner = "";

        for (Staff staff : staffList) {
            int pay = staff.calculatePay();
            Payslip payslip = new Payslip(staff.getName(), staff.getType(), pay);
            System.out.println(payslip);

            totalPay += pay;
            if (pay > maxPay) {
                maxPay = pay;
                topEarner = staff.getName();
            }
        }

        System.out.println("Total " + totalPay);
        System.out.println("top earner " + topEarner);
    }

    public static void main(String[] args) {
        PayrollRegisterSystem system = new PayrollRegisterSystem();
        system.addStaff(new FullTimeStaff("Asha", 50000));
        system.addStaff(new PartTimeStaff("Ravi", 80, 300));
        system.addStaff(new InternStaff("Neha", 15000));

        system.generatePayrollReport();
    }
}
