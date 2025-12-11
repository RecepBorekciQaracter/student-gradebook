package org.example;


import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    private static int LIST_SIZE = 30;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<Student>(LIST_SIZE);

        while (true) {
            System.out.println("Welcome to the Student Gradebook app! Please select an option: ");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Get Highest Note");
            System.out.println("5. Get Lowest Note");
            System.out.println("6. Get Class Average");
            System.out.println("7. Get Report");
            System.out.println("8. Exit");

            int choice = readInt(sc, "\nPlease enter your choice: ");

            switch (choice) {
                case 1: // Do WHILE to ask information
                    System.out.println("Introduce student name: ");
                    String name = sc.nextLine();
                    System.out.println("Introduce student grade (X.X): ");
                    double grade = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Introduce initial comment: ");
                    String comment = sc.nextLine();

                    studentList.add(new Student(name, grade, comment));

                    //TEST
                    for(int i = 0; i< studentList.size();i++) {
                        System.out.println(studentList.get(i).toString());
                    }

                    break;
                case 2:
                    // View Students
                    // viewStudents();
                    break;
                case 3:
                    // Delete Student
                    // deleteStudent();
                    break;
                case 4:
                    // Get Highest Note
                    // getHighestNote();
                    break;
                case 5:
                    // Get Lowest Note
                    // getLowestNote();
                    break;
                case 6:
                    // Get Report (Print highest note, lowest note, and average of the class using string builder)
                    // getReport();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.\n");

            }
        }

    }

    public static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine(); // clear leftover newline
                return value;
            } else {
                System.out.println("Please enter a valid number.");
                sc.nextLine(); // discard bad input
            }
        }
    }
}
