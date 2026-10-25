package advanced_oop.assigment_problems;

public class TrainCoachesBothWays {

    public static void main(String[] args) {
        TrainDoublyLinkedList train = new TrainDoublyLinkedList();
        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        train.remove("B1");

        train.printForward();
        train.printBackward();
    }
}
