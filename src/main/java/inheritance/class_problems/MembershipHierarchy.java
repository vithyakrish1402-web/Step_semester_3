package inheritance.class_problems;

public class MembershipHierarchy {

    public static void main(String[] args) {
        StudentMember studentMember = new StudentMember("STU2", 3, "CSE");
        HonorsStudentMember honorsMember = new HonorsStudentMember("STU3", 3, "ECE", 2);
        FacultyMember facultyMember = new FacultyMember("STU4", 5, "Physics");

        studentMember.borrowBook();
        studentMember.borrowBook();
        honorsMember.borrowBook();
        facultyMember.borrowBook();
        facultyMember.borrowBook();
        facultyMember.borrowBook();

        System.out.println(LibraryMember.classifyGeneration(honorsMember));
        System.out.println(LibraryMember.classifyGeneration(facultyMember));

        LibraryMember[] members = {studentMember, honorsMember, facultyMember};
        System.out.println(LibraryMember.getTotalBooksBorrowed(members));
    }
}
