package abstract_interfaces.class_problems;

public class PackageDropOffLog {

    public static void main(String[] args) {
        ParcelNote p = new ParcelNote("TRK-1");
        System.out.println(p.confirmDelivery());

        System.out.println(p.confirmDelivery("J. Smith"));

        DeliveryNote ref = p;
        DeliveryNote.logAll(new DeliveryNote[]{ ref, new LetterNote("TRK-2") });
    }
}
