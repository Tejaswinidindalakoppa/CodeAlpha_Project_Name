import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.println("Welcome to the Student Grade Tracker!");

        // Input grades
        System.out.println("Enter student grades (type -1 to stop):");
        while (true) {
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            if (grade == -1) {
                break;
            }
            if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
            } else {
                grades.add(grade);
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
        } else {
            // Calculate average, highest, and lowest grades
            int sum = 0;
            int highest = grades.get(0);
            int lowest = grades.get(0);

            for (int grade : grades) {
                sum += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = (double) sum / grades.size();

            // Display results
            System.out.println("\nGrade Summary:");
            System.out.println("Number of students: " + grades.size());
            System.out.println("Average grade: " + String.format("%.2f", average));
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        }

        scanner.close();
    }
}
