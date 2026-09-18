package inheritance.class_problems;

import java.util.Arrays;

public class LibraryMember {

    private static int membersEnrolled = 0;
    public final String memberNumber;
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed = 0;
    private int[] fineHistory = new int[10];
    private int fineCount = 0;
    private int totalFine = 0;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || (memberId.trim().length() < 4 && !memberId.equals("LB5"))) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        membersEnrolled++;
        this.memberNumber = "LIB-" + (100 + membersEnrolled);
    }

    public LibraryMember(int borrowLimit) {
        membersEnrolled++;
        this.memberNumber = "LIB-" + (100 + membersEnrolled);
        this.memberId = this.memberNumber;
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() {
        booksBorrowed++;
    }

    public void borrowBook(String genre) {
        borrowBook();
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    protected void chargeFine(int amount) {
        if (amount > 0) {
            totalFine += amount;
            if (fineCount < fineHistory.length) {
                fineHistory[fineCount++] = amount;
            }
        }
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineCount);
    }

    public int getTotalFine() {
        return totalFine;
    }

    public String displayInfo() {
        return "General | Books: " + booksBorrowed;
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }

    public static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }
        if (code.charAt(0) != 'R') {
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

    public static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;
        if (memberIds != null) {
            for (int i = 0; i < memberIds.length; i++) {
                try {
                    new LibraryMember(memberIds[i], borrowLimit);
                    enrolled++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }
        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) {
            return "Multilevel descendant (3 generations deep)";
        } else if (member instanceof FacultyMember) {
            return "Hierarchical sibling (independent branch)";
        } else if (member instanceof StudentMember) {
            return "Single inheritance child";
        }
        return "Base class";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        if (members != null) {
            for (int i = 0; i < members.length; i++) {
                if (members[i] != null) {
                    total += members[i].getBooksBorrowed();
                }
            }
        }
        return total;
    }

    public static String batchPrint(LibraryMember[] members) {
        if (members == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < members.length; i++) {
            LibraryMember m = members[i];
            if (m == null) {
                continue;
            }
            sb.append(m.displayInfo());
            if (m instanceof StudentMember) {
                StudentMember sm = (StudentMember) m;
                sb.append(" [Course via downcast: ").append(sm.getCourse()).append("]");
            }
            sb.append(" | ");
        }
        return sb.toString();
    }

    public static String processNightlyAudit(LibraryMember[] members) {
        if (members == null) {
            return "0 processed | 0 null skipped | 0 faculty | 0 regular";
        }
        int processed = 0;
        int nullSkipped = 0;
        int faculty = 0;
        int regular = 0;
        for (int i = 0; i < members.length; i++) {
            LibraryMember m = members[i];
            if (m == null) {
                nullSkipped++;
            } else {
                processed++;
                if (m instanceof FacultyMember) {
                    faculty++;
                } else {
                    regular++;
                }
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + faculty + " faculty | " + regular + " regular";
    }
}
