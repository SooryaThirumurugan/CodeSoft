//import java.util.Scanner;
//
//public class MarksCalculator {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Enter the number of subjects: ");
//        int numSubjects = scanner.nextInt();
//
//        int[] marks = new int[numSubjects];
//        int totalMarks = 0;
//
//        for (int i = 0; i < numSubjects; i++) {
//            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
//            marks[i] = scanner.nextInt();
//            totalMarks += marks[i];
//        }
//
//        double averagePercentage = totalMarks / (double) numSubjects;
//        char grade = calculateGrade(averagePercentage);
//
//        System.out.println("\nResults:");
//        System.out.println("Total Marks: " + totalMarks);
//        System.out.println("Average Percentage: " + averagePercentage + "%");
//        System.out.println("Grade: " + grade);
//        
//        scanner.close();
//    }
//
//    public static char calculateGrade(double averagePercentage) {
//        if (averagePercentage >= 90) {
//            return 'A';
//        } else if (averagePercentage >= 80) {
//            return 'B';
//        } else if (averagePercentage >= 70) {
//            return 'C';
//        } else if (averagePercentage >= 60) {
//            return 'D';
//        } 
//        return 'F';
//    }
//    
//}

import java.util.Scanner;

public class MarksCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        if (numSubjects <= 0) {
            System.out.println("The number of subjects must be positive.");
            scanner.close();
            return;
        }

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            int mark = scanner.nextInt();
            
            while (mark < 0 || mark > 100) {
                System.out.print("Invalid input. Please enter marks between 0 and 100: ");
                mark = scanner.nextInt();
            }
            
            marks[i] = mark;
            totalMarks += mark;
        }

        double averagePercentage = totalMarks / (double) numSubjects;
        char grade = calculateGrade(averagePercentage);

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } 
        return 'F';
    }
}
