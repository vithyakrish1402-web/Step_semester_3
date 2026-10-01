package abstract_interfaces.class_problems;

public abstract class DeliveryNote {

    protected String trackingId;

    public DeliveryNote(String trackingId) {
        this.trackingId = trackingId;
    }

    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {
        return confirmDelivery() + ", signed by " + signature;
    }

    public static void logAll(DeliveryNote[] notes) {
        if (notes != null) {
            for (int i = 0; i < notes.length; i++) {
                if (notes[i] != null) {
                    System.out.println(notes[i].confirmDelivery());
                }
            }
        }
    }
}
