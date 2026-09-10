package access_modifiers.class_problems;

class PremiumMovieTicket extends MovieTicket {
    private double loyaltyDiscount;

    public PremiumMovieTicket(String seatNumber, int screenId, double ticketPrice, String movieTitle, double loyaltyDiscount) {
        super(seatNumber, screenId, ticketPrice, movieTitle);
        this.loyaltyDiscount = loyaltyDiscount;
    }

    public double getDiscountedPrice() {
        return this.ticketPrice - loyaltyDiscount;
    }
}

public class SubclassTicketAccess {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        return AccessChecker.classifyAccess(fieldModifier, accessorContext);
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));
    }
}
