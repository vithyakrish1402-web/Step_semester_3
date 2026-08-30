package oop_constructs.class_problems;

public class EmployeePayroll {

    private String empId;
    private double salary;

    public EmployeePayroll(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public void printSalary() {
        System.out.println(this.empId + " | Final Salary: Rs " + this.salary);
    }

    public static void main(String[] args) {
        String[] ids = {"E-101", "E-102", "E-103", "E-104"};
        double[] startingSalaries = {40000, 55000, 62000, 48000};
        EmployeePayroll[] employees = new EmployeePayroll[ids.length];

        for (int i = 0; i < ids.length; i++) {
            employees[i] = new EmployeePayroll(ids[i], startingSalaries[i]);
            employees[i].raiseSalary(5000);
            employees[i].printSalary();
        }
    }
}
