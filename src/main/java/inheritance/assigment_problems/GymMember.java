package inheritance.assigment_problems;

import java.util.Arrays;

public class GymMember {

    private static int membersEnrolled = 0;
    public final String membershipNumber;
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended = 0;
    private int[] lateFeeHistory = new int[10];
    private int lateFeeCount = 0;
    private int totalLateFees = 0;
    private int feesPaid = 0;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        membersEnrolled++;
        this.membershipNumber = "GYM-" + (2000 + membersEnrolled);
    }

    public GymMember(int monthlyFee) {
        membersEnrolled++;
        this.membershipNumber = "GYM-" + (2000 + membersEnrolled);
        this.memberId = this.membershipNumber;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    protected void chargeLateFee(int amount) {
        if (amount > 0) {
            totalLateFees += amount;
            if (lateFeeCount < lateFeeHistory.length) {
                lateFeeHistory[lateFeeCount++] = amount;
            }
        }
    }

    public int[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public int getTotalLateFees() {
        return totalLateFees;
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public String displayInfo() {
        return "Standard | Sessions: " + sessionsAttended;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'G') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) {
            return false;
        }
        if (!Character.isUpperCase(code.charAt(3))) {
            return false;
        }
        return true;
    }

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;
        if (memberIds != null) {
            for (int i = 0; i < memberIds.length; i++) {
                try {
                    new GymMember(memberIds[i], monthlyFee);
                    signedUp++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }
        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(GymMember member) {
        if (member instanceof EliteMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof GroupClassMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof PremiumMember) {
            return "Single inheritance child";
        }
        return "Base class";
    }

    public static int getTotalSessionsAttended(GymMember[] members) {
        int total = 0;
        if (members != null) {
            for (int i = 0; i < members.length; i++) {
                if (members[i] != null) {
                    total += members[i].getSessionsAttended();
                }
            }
        }
        return total;
    }

    public static String batchPrint(GymMember[] members) {
        if (members == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < members.length; i++) {
            GymMember m = members[i];
            if (m == null) {
                continue;
            }
            sb.append(m.displayInfo());
            if (m instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) m;
                sb.append(" [Trainer via downcast: ").append(pm.getTrainerName()).append("]");
            }
            sb.append(" | ");
        }
        return sb.toString();
    }

    public static String processWeeklyCheckIn(GymMember[] members) {
        if (members == null) {
            return "0 processed | 0 null skipped | 0 group | 0 individual";
        }
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;
        for (int i = 0; i < members.length; i++) {
            GymMember m = members[i];
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof GroupClassMember) {
                    group++;
                } else {
                    individual++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual";
    }
}
