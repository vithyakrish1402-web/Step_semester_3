package inheritance.class_problems;

public class CirculationReport {

    public static void main(String[] args) {
        LibraryMember[] members = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };
        System.out.println(LibraryMember.batchPrint(members));
    }
}
