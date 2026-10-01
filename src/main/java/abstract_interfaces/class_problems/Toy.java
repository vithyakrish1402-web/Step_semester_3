package abstract_interfaces.class_problems;

public abstract class Toy {

    private static int counter = 1000;
    private final String toyId;

    public Toy() {
        counter++;
        this.toyId = "TOY-" + counter;
    }

    public String getToyId() {
        return toyId;
    }

    public abstract String makeSound();
}
