package object_oriented_design.assigment_problems;

public class HostelLaundryQueue {

    public WashCycle startWash(Student student, WashingMachine machine, WashType washType) {
        if (machine.isBusy()) {
            System.out.println("Machine " + machine.getMachineId() + " is currently busy.");
            return null;
        }
        machine.setBusy(true);
        WashCycle cycle = new WashCycle(student, machine, washType);
        System.out.printf("%s wash started on %s for %s (%d min). Charge: \u20B9%.2f.%n",
                washType.getName(), machine.getMachineId(), student.getName(), washType.getDurationMinutes(), washType.getCharge());
        return cycle;
    }

    public void completeWash(WashingMachine machine) {
        machine.setBusy(false);
        System.out.println(machine.getMachineId() + " cycle completed. " + machine.getMachineId() + " is now free.");
    }

    public static void main(String[] args) {
        HostelLaundryQueue queue = new HostelLaundryQueue();

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashType quick = new QuickWash();
        WashType normal = new NormalWash();
        WashType heavy = new HeavyWash();

        queue.startWash(asha, m1, quick);
        queue.startWash(ravi, m1, heavy);
        queue.startWash(ravi, m2, heavy);
        queue.completeWash(m1);
        queue.startWash(neha, m1, normal);
    }
}
