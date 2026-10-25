package advanced_oop.class_problems;

import java.util.ArrayList;
import java.util.List;

public class ClassMarksGridAnalysis {

    public static class StudentMarksRecord {
        private String name;
        private int[] marks;

        public StudentMarksRecord(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public int[] getMarks() {
            return marks;
        }

        public int getTotal() {
            int total = 0;
            if (marks != null) {
                for (int m : marks) {
                    total += m;
                }
            }
            return total;
        }
    }

    public static void analyzeMarks(List<StudentMarksRecord> students) {
        if (students == null || students.isEmpty()) {
            return;
        }

        StringBuilder totalsSb = new StringBuilder("Totals ");
        int topTotal = -1;
        String topperName = "";
        int numSubjects = students.get(0).getMarks().length;
        double[] subjectSums = new double[numSubjects];

        for (int i = 0; i < students.size(); i++) {
            StudentMarksRecord s = students.get(i);
            int total = s.getTotal();
            totalsSb.append(s.getName()).append(" ").append(total);
            if (i < students.size() - 1) {
                totalsSb.append(", ");
            }

            if (total > topTotal) {
                topTotal = total;
                topperName = s.getName();
            }

            int[] m = s.getMarks();
            for (int sub = 0; sub < numSubjects; sub++) {
                subjectSums[sub] += m[sub];
            }
        }
        System.out.println(totalsSb.toString());

        StringBuilder averagesSb = new StringBuilder("averages ");
        for (int sub = 0; sub < numSubjects; sub++) {
            double avg = subjectSums[sub] / students.size();
            averagesSb.append(String.format("%.2f", avg));
            if (sub < numSubjects - 1) {
                averagesSb.append(", ");
            }
        }
        System.out.println(averagesSb.toString());

        System.out.println("topper " + topperName + " (" + topTotal + ")");
    }

    public static void main(String[] args) {
        List<StudentMarksRecord> students = new ArrayList<>();
        students.add(new StudentMarksRecord("Asha", new int[]{78, 85, 90}));
        students.add(new StudentMarksRecord("Ravi", new int[]{88, 92, 79}));
        students.add(new StudentMarksRecord("Neha", new int[]{65, 70, 95}));

        analyzeMarks(students);
    }
}
