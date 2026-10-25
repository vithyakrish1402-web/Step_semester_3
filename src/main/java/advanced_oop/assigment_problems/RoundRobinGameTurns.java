package advanced_oop.assigment_problems;

public class RoundRobinGameTurns {

    public static void main(String[] args) {
        CircularPlayerList game = new CircularPlayerList();
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");

        game.printTurns(7);
    }
}
