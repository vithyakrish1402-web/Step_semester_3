package class_problems;

import java.util.Random;

public class BmiCalculatorTeam {


    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }


    public static void printWellnessReport(double[] heights, double[] weights) {
        int teamSize = heights.length;

        System.out.println("==========================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("==========================================================================");

        for (int i = 0; i < teamSize; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-12.2f | %-12.1f | %-8.2f | %-15s%n",
                    (i + 1), h, w, bmi, status);
        }
        System.out.println("==========================================================================");
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];


        Random rand = new Random();
        for (int i = 0; i < teamSize; i++) {

            heights[i] = 1.50 + (rand.nextDouble() * 0.45);

            weights[i] = 45 + (rand.nextDouble() * 65);
        }

        heights[0] = 1.75; weights[0] = 70.0;
        heights[1] = 1.60; weights[1] = 90.0;

        System.out.println("=== Corporate Wellness Program: BMI Report ===");
        printWellnessReport(heights, weights);
    }
}