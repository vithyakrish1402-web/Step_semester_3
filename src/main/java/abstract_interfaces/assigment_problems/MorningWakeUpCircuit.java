package abstract_interfaces.assigment_problems;

public class MorningWakeUpCircuit {

    public static void ringAll(Ringable[] devices) {
        if (devices != null) {
            for (int i = 0; i < devices.length; i++) {
                if (devices[i] != null) {
                    System.out.println(devices[i].ring());
                }
            }
        }
    }

    public static void main(String[] args) {
        AlarmClock a = new AlarmClock("7:00 AM");
        System.out.println(a.ring());

        Doorbell d = new Doorbell("Front Door");
        System.out.println(d.ring());

        ringAll(new Ringable[]{ a, d });
    }
}
