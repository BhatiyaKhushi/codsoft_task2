package com.codesoft.sgc;

import java.util.Scanner;

public class StudentGradeCalculator {
    
    public static String calculateGrade(double average) {
        if (average >= 90) {
            return "A+";
        } else if (average >= 80) {
            return "A";
        } else if (average >= 70) {
            return "B+";
        } else if (average >= 60) {
            return "B";
        } else if (average >= 50) {
            return "C";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the student's name: ");
        String studentName = scanner.nextLine();
        
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        scanner.nextLine();  
        
        String[] subjectNames = new String[numberOfSubjects];
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;
        
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter the name of subject " + (i + 1) + ": ");
            subjectNames[i] = scanner.nextLine();
            
            int mark;
            do {
                System.out.print("Enter the marks obtained in " + subjectNames[i] + " (out of 100): ");
                mark = scanner.nextInt();
                if (mark < 0 || mark > 100) {
                    System.out.println("Please enter valid marks between 0 and 100.");
                }
            } while (mark < 0 || mark > 100);
            
            marks[i] = mark;
            totalMarks += mark;
            scanner.nextLine(); 
        }
        
        double averagePercentage = (double) totalMarks / numberOfSubjects;
        
        String grade = calculateGrade(averagePercentage);
        
        System.out.println("\n --- Student Grade Report ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Subjects and Marks:");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.println(subjectNames[i] + ": " + marks[i]);
        }
        System.out.println("Total Marks: " + totalMarks + " out of " + (100 * numberOfSubjects));
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
    }
}
