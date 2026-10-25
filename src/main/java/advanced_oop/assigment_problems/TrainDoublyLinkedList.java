package advanced_oop.assigment_problems;

public class TrainDoublyLinkedList {

    private CoachNode head;
    private CoachNode tail;
    private int size;

    public TrainDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addLast(String name) {
        CoachNode newNode = new CoachNode(name);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(String name) {
        CoachNode curr = head;
        while (curr != null) {
            if (curr.name.equals(name)) {
                if (curr == head && curr == tail) {
                    head = null;
                    tail = null;
                } else if (curr == head) {
                    head = head.next;
                    head.prev = null;
                } else if (curr == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void printForward() {
        StringBuilder sb = new StringBuilder("Forward: ");
        CoachNode curr = head;
        while (curr != null) {
            sb.append(curr.name);
            if (curr.next != null) {
                sb.append(" <-> ");
            }
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }

    public void printBackward() {
        StringBuilder sb = new StringBuilder("Backward: ");
        CoachNode curr = tail;
        while (curr != null) {
            sb.append(curr.name);
            if (curr.prev != null) {
                sb.append(" <-> ");
            }
            curr = curr.prev;
        }
        System.out.println(sb.toString());
    }
}
