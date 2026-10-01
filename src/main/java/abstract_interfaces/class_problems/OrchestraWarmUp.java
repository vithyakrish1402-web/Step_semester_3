package abstract_interfaces.class_problems;

public class OrchestraWarmUp {

    public static void main(String[] args) {
        StringInstrument s = new StringInstrument();
        System.out.println(s.play());

        Violin v = new Violin();
        System.out.println(v.play());
    }
}
