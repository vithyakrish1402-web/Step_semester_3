package advanced_oop.assigment_problems;

public class CircularPlayerList {

    private PlayerNode tail;
    private int size;

    public CircularPlayerList() {
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void addLast(String name) {
        PlayerNode newNode = new PlayerNode(name);
        if (tail == null) {
            newNode.next = newNode;
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void printTurns(int turns) {
        if (tail == null || turns <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        PlayerNode curr = tail.next;
        for (int i = 0; i < turns; i++) {
            sb.append(curr.name);
            if (i < turns - 1) {
                sb.append(" ");
            }
            curr = curr.next;
        }
        System.out.println(sb.toString());
    }
}
