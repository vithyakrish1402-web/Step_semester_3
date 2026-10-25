package advanced_oop.assigment_problems;

public class CancelledOrdersCleanup {

    public static Node removeAll(Node head, int code) {
        while (head != null && head.data == code) {
            head = head.next;
        }

        Node curr = head;
        while (curr != null && curr.next != null) {
            if (curr.next.data == code) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static Node buildList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        Node head = new Node(values[0]);
        Node curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new Node(values[i]);
            curr = curr.next;
        }
        return head;
    }

    public static String listToString(Node head) {
        if (head == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data).append(" -> ");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static void main(String[] args) {
        Node orders1 = buildList(new int[]{5, 3, 5, 8, 5});
        Node cleaned1 = removeAll(orders1, 5);
        System.out.println(listToString(cleaned1));

        Node orders2 = buildList(new int[]{5, 5, 5});
        Node cleaned2 = removeAll(orders2, 5);
        System.out.println(listToString(cleaned2));
    }
}
