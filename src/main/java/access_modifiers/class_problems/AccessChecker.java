package access_modifiers.class_problems;

class MovieTicket {
    private String seatNumber;
    int screenId;
    protected double ticketPrice;
    public String movieTitle;

    public MovieTicket(String seatNumber, int screenId, double ticketPrice, String movieTitle) {
        this.seatNumber = seatNumber;
        this.screenId = screenId;
        this.ticketPrice = ticketPrice;
        this.movieTitle = movieTitle;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}

public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        switch (fieldModifier.toLowerCase()) {
            case "public":
                return "ALLOWED";

            case "private":
                return accessorContext.equalsIgnoreCase("SAME_CLASS") ? "ALLOWED" : "DENIED";

            case "default":
                if (accessorContext.equalsIgnoreCase("SAME_CLASS") || 
                    accessorContext.equalsIgnoreCase("SAME_PACKAGE")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "protected":
                if (accessorContext.equalsIgnoreCase("SAME_CLASS") || 
                    accessorContext.equalsIgnoreCase("SAME_PACKAGE") ||
                    accessorContext.equalsIgnoreCase("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                    return "ALLOWED";
                }
                return "DENIED";

            default:
                return "DENIED";
        }
    }

    public static String summarizeBatch(String[][] attempts) {
        if (attempts == null) {
            return "Allowed: 0 | Denied: 0";
        }

        int allowedCount = 0;
        int deniedCount = 0;

        for (int i = 0; i < attempts.length; i++) {
            String result = classifyAccess(attempts[i][0], attempts[i][1]);
            if (result.equals("ALLOWED")) {
                allowedCount++;
            } else {
                deniedCount++;
            }
        }

        return "Allowed: " + allowedCount + " | Denied: " + deniedCount;
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] attempts = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeBatch(attempts));
    }
}
