package abstract_interfaces.assigment_problems;

public class DigitalClassroomSetup {

    public static void main(String[] args) {
        Tablet t = new Tablet("TAB-5");
        System.out.println(t.operate());

        System.out.println(t.charge());

        System.out.println(t.charge(30));
    }
}
