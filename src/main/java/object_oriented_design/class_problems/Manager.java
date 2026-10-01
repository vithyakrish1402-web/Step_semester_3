package object_oriented_design.class_problems;

public class Manager {

    private String id;
    private String name;

    public Manager(String name) {
        this.id = name;
        this.name = name;
    }

    public Manager(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void approveRequest(LeaveRequest request) {
        request.changeStatus(LeaveStatus.APPROVED);
        System.out.println(request.getEmployee().getName() + "'s leave request (" + request.getDateRange() + ") approved. Status: Approved.");
    }

    public void rejectRequest(LeaveRequest request) {
        request.changeStatus(LeaveStatus.REJECTED);
        System.out.println(request.getEmployee().getName() + "'s leave request (" + request.getDateRange() + ") rejected. Status: Rejected.");
    }
}
