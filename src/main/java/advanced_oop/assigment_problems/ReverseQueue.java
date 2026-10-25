package advanced_oop.assigment_problems;

public class ReverseQueue {

    public static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
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
        Node queue1 = buildList(new int[]{1, 2, 3, 4});
        Node reversed1 = reverse(queue1);
        System.out.println(listToString(reversed1));

        Node queue2 = buildList(new int[]{9});
        Node reversed2 = reverse(queue2);
        System.out.println(listToString(reversed2));
    }
}
