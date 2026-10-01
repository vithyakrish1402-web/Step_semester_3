package object_oriented_design.class_problems;

public class EmployeeLeaveWorkflow {

    private static int requestCounter = 0;

    public static LeaveRequest submitLeave(Employee employee, String dateRange, int days) {
        LeaveRequest request = new LeaveRequest("LR-" + (++requestCounter), employee, dateRange, days);
        System.out.println("Leave request submitted for " + employee.getName() + " (" + dateRange + "). Status: Pending.");
        return request;
    }

    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John");
        Manager alice = new Manager("Alice");
        LeaveRequest req1 = submitLeave(john, "Jan 1-5", 5);
        alice.approveRequest(req1);

        Employee jane = new PartTimeEmployee("Jane");
        Manager bob = new Manager("Bob");
        LeaveRequest req2 = submitLeave(jane, "Feb 10-11", 2);
        bob.rejectRequest(req2);

        req1.changeStatus(LeaveStatus.PENDING);
    }
}
