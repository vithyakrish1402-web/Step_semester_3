package access_modifiers.assigment_problems;

public class ReferenceDeskAccess {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        return LibraryMemberAccessChecker.classifyAccess(fieldModifier, accessorContext);
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null || attempts.length == 0) {
            return "None Denied";
        }

        for (int i = 0; i < attempts.length; i++) {
            String mod = attempts[i][0];
            String ctx = attempts[i][1];
            String result = classifyAccess(mod, ctx);

            if (result.equals("DENIED")) {
                return mod + " via " + ctx + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }

    public static void main(String[] args) {
        String[][] attempts1 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(attempts1));

        String[][] attempts2 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(attempts2));
    }
}
