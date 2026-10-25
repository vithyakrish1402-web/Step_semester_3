package advanced_oop.assigment_problems;

public class CoachNode {

    public String name;
    public CoachNode prev;
    public CoachNode next;

    public CoachNode(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }
}
