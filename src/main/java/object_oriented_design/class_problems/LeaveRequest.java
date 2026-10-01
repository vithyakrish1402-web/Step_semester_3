package object_oriented_design.class_problems;

public class LeaveRequest {

    private String requestId;
    private Employee employee;
    private String dateRange;
    private int days;
    private LeaveStatus status;

    public LeaveRequest(String requestId, Employee employee, String dateRange, int days) {
        this.requestId = requestId;
        this.employee = employee;
        this.dateRange = dateRange;
        this.days = days;
        this.status = LeaveStatus.PENDING;
    }

    public String getRequestId() {
        return requestId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getDateRange() {
        return dateRange;
    }

    public int getDays() {
        return days;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public void changeStatus(LeaveStatus newStatus) {
        if ((this.status == LeaveStatus.APPROVED || this.status == LeaveStatus.REJECTED) && newStatus == LeaveStatus.PENDING) {
            System.out.println("Cannot change leave request status from " + formatStatus(this.status) + " to " + formatStatus(newStatus) + ".");
            return;
        }
        this.status = newStatus;
    }

    private String formatStatus(LeaveStatus s) {
        String n = s.name();
        return n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase();
    }
}
