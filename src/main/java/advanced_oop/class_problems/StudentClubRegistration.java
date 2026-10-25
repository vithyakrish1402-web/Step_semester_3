package advanced_oop.class_problems;

import java.util.HashSet;
import java.util.Set;

public class StudentClubRegistration {

    private Set<ClubMember> members = new HashSet<>();

    public boolean addMember(String rollNumber, String name) {
        ClubMember member = new ClubMember(rollNumber, name);
        boolean added = members.add(member);
        if (added) {
            System.out.println("Added");
        } else {
            System.out.println("duplicate rejected");
        }
        return added;
    }

    public void printMemberCount() {
        System.out.println("member count " + members.size());
    }

    public boolean containsMember(String rollNumber, String name) {
        ClubMember dummy = new ClubMember(rollNumber, name);
        boolean exists = members.contains(dummy);
        System.out.println("contains: " + exists);
        return exists;
    }

    public static void main(String[] args) {
        StudentClubRegistration reg = new StudentClubRegistration();
        reg.addMember("21CS01", "Asha");
        reg.addMember("21CS01", "Asha");
        reg.addMember("21CS02", "Ravi");
        reg.printMemberCount();
        reg.containsMember("21CS02", "Ravi");
        reg.containsMember("21CS03", "Priya");
    }
}
