package org.example;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static int LIST_SIZE = 30;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<Student>(LIST_SIZE);

        ArrayList<Student> supportList = new ArrayList<Student>(LIST_SIZE);
        Student buffer = null;
        
        while (true) {
            System.out.println("Welcome to the Student Gradebook app! Please select an option: ");

            System.out.println("1. Add Student");
            System.out.println("2. Add Student grade");
            System.out.println("3. Add Student comment");
            System.out.println("4. View Students");
            System.out.println("5. Delete Student");
            System.out.println("6. Get Highest Note");
            System.out.println("7. Get Lowest Note");
            System.out.println("8. Get Class Average");
            System.out.println("9. Get Report");
            System.out.println("10. Exit");

            int choice = readInt(sc, "\nPlease enter your choice: ");

            switch (choice) {
                case 1: // Do WHILE to ask information
                    addStudent(sc, studentList);
                    break;
                case 2:
                    System.out.println("Please select student:");
                    for(int i = 0; i<studentList.size(); i++) {
                        System.out.println(i + " " + studentList.get(i).name);
                    }
                    System.out.println("Introduce student number: ");
                    int a = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Introduce grade X.X: ");
                    double grade = sc.nextDouble();
                    sc.nextLine();

                    studentList.get(a).gradesAL.add(grade);

                    break;

                case 3:
                    System.out.println("Please select student:");
                    for(int i = 0; i<studentList.size(); i++) {
                        System.out.println(i + " " + studentList.get(i).name);
                    }
                    System.out.println("Introduce student number: ");
                    int b = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Introduce comment to add: ");
                    String coment = sc.nextLine();

                    StringBuilder sb = new StringBuilder();

                    sb.append(studentList.get(b).comment).append(", ").append(coment);

                    studentList.get(b).comment = sb.toString();

                    break;
                case 4:
                    // View Students
                    viewStudents(studentList);
                    break;
                case 5:
                    // Delete Student
                    deleteStudent(sc, studentList);
                    break;
                case 6:
                    // Display the highest note. And get the students with the highest note.
                    getHighestNote(sc, studentList, supportList, buffer);
                    break;
                case 7:
                    // Display the lowest note. And get the students with the lowest note.
                    getLowestNote(sc, studentList, supportList, buffer);
                    break;
                case 8:
                    // Get class average
                    getClassAverage(sc, studentList);
                    break;
                case 9:
                    // Get Report (Print highest note, lowest note, and average of the class using string builder)
                    getReport(studentList);
                    break;
                case 10:
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

    public static void addStudent(Scanner sc, ArrayList<Student> studentList) {
        System.out.println("Introduce student name: ");
        String name = sc.nextLine();
        System.out.println("Introduce student grade (X.X): ");
        Double grade = sc.nextDouble();
        ArrayList<Double> grades = new ArrayList<>();
        grades.add(grade);
        sc.nextLine();
        System.out.println("Introduce initial comment: ");
        String comment = sc.nextLine();
        studentList.add(new Student(name, grades, comment));

        System.out.println("Student has been added successfully!");
    }

    public static void viewStudents(ArrayList<Student>  studentList) {
        // Print the student Information

        System.out.println("---All Student Information---");
        for(int i = 0; i< studentList.size();i++) {
            System.out.println(studentList.get(i).toString());
            System.out.println();
        }
    }
    public static void deleteStudent(Scanner sc, ArrayList<Student> studentList) {
        System.out.println("Enter Student Name to Delete: ");
        String name = sc.nextLine();

        boolean removed = studentList.removeIf(student -> student.name.equalsIgnoreCase(name));

        if (removed) {
            System.out.println("Student \"" + name + "\" has been deleted.");
        } else {
            System.out.println("No student found with that name.");
        }
    }

    public static void getHighestNote(Scanner sc, ArrayList<Student> studentList, ArrayList<Student> supportList, Student buffer) {
        double highestGrade = -1.0;
        Student curStudent = null;

        for (int i = 0; i< studentList.size();i++) {
            curStudent = studentList.get(i);
            if (curStudent.highestGrade() > highestGrade) {
                highestGrade = curStudent.highestGrade();
            }
        }

        System.out.println("The Highest grade is a : " + highestGrade);
    }

    public static void getLowestNote(Scanner sc, ArrayList<Student> studentList, ArrayList<Student> supportList, Student buffer) {
        double lowestGrade = 1000000000000.0;
        Student curStudent = null;

        for (int i = 0; i< studentList.size();i++) {
            curStudent = studentList.get(i);
            if (curStudent.lowestGrade() < lowestGrade) {
                lowestGrade = curStudent.lowestGrade();
            }
        }


        System.out.println("The Lowest grade is a : " + lowestGrade);
    }

    public static void getClassAverage(Scanner sc, ArrayList<Student> studentList) {
        if (!(studentList.isEmpty())) {
            System.out.print("Average class grade: ");
            double average = 0.0;
            Student curStudent = null;
            for (int i = 0; i< studentList.size();i++) {
                average = average + studentList.get(i).average();
            }
            average = average / studentList.size();

            System.out.println("The average class grade is a : " + average);
        }
    }

    public static void getReport(ArrayList<Student> studentList) {
        double highestGrade = -1.0;
        double lowestGrade = 1000000000000.0;
        double average = 0.0;
        Student curStudent = null;

        for (int i = 0; i< studentList.size();i++) {
            curStudent = studentList.get(i);
            if (curStudent.highestGrade() > highestGrade) {
                highestGrade = curStudent.highestGrade();
            }
        }

        for (int i = 0; i< studentList.size();i++) {
            curStudent = studentList.get(i);
            if (curStudent.lowestGrade() < lowestGrade) {
                lowestGrade = curStudent.lowestGrade();
            }
        }

        for (int i = 0; i< studentList.size();i++) {
            average = average + studentList.get(i).average();
        }

        average = average / studentList.size();

        StringBuilder sb = new StringBuilder();

        sb.append("---Report---\n").append("Highest grade in the class is: ").append(highestGrade).append("\n");
        sb.append("Lowest grade in the class is: ").append(lowestGrade).append("\n");
        sb.append("Average grade is a : ").append(String.format("%.4f", average)).append("\n");

        System.out.println(sb);

    }

}
