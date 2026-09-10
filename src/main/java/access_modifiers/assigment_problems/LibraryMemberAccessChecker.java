package access_modifiers.assigment_problems;

class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    public LibraryMember(String membershipPin, String branchCode, double finesOwed, String displayName) {
        this.membershipPin = membershipPin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }

    public String getMembershipPin() {
        return membershipPin;
    }
}

public class LibraryMemberAccessChecker {

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

    public static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowed = new int[4];
        int[] denied = new int[4];

        if (attempts != null) {
            for (int i = 0; i < attempts.length; i++) {
                String mod = attempts[i][0];
                String ctx = attempts[i][1];
                String res = classifyAccess(mod, ctx);

                for (int j = 0; j < modifiers.length; j++) {
                    if (modifiers[j].equalsIgnoreCase(mod)) {
                        if (res.equals("ALLOWED")) {
                            allowed[j]++;
                        } else {
                            denied[j]++;
                        }
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < modifiers.length; i++) {
            sb.append(modifiers[i]).append(": ")
              .append(allowed[i]).append(" allowed / ")
              .append(denied[i]).append(" denied");
            if (i < modifiers.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(attempts));
    }
}
