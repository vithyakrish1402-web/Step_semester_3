package abstract_interfaces.class_problems;

public class WarehouseLabelPrinter {

    public static void printAll(Printable[] items) {
        if (items != null) {
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) {
                    System.out.println(items[i].printLabel());
                }
            }
        }
    }

    public static void main(String[] args) {
        PackageBox p = new PackageBox("TRK-88");
        System.out.println(p.printLabel());

        Invoice i = new Invoice("INV-42");
        System.out.println(i.printLabel());

        printAll(new Printable[]{ p, i });
    }
}
