package advanced_oop.assigment_problems;

public class PriorityTokenInsertion {

    public static void main(String[] args) {
        PriorityTokenList list = new PriorityTokenList();
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);

        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);

        list.printList();
    }
}
