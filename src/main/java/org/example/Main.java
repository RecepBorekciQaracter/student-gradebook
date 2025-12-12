package org.example;

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
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Get Highest Note");
            System.out.println("5. Get Lowest Note");
            System.out.println("6. Get Class Average");
            System.out.println("7. Get Report");
            System.out.println("8. Exit");
            System.out.println("9. Add Student grade");
            System.out.println("10. Add Student comment");

            int choice = readInt(sc, "\nPlease enter your choice: ");

            switch (choice) {
                case 1: // Do WHILE to ask information
                    addStudent(sc, studentList);
                    break;
                case 2:
                    // View Students
                    viewStudents(studentList);
                    break;
                case 3:
                    // Delete Student
                    deleteStudent(sc, studentList);
                    break;
                case 4:
                    // Display the highest note. And get the students with the highest note.
                    getHighestNote(sc, studentList, supportList, buffer);
                    break;
                case 5:
                    // Display the lowest note. And get the students with the lowest note.
                    getLowestNote(sc, studentList, supportList, buffer);
                    break;
                case 6:
                    // Get class average
                    getClassAverage(sc, studentList);
                    break;
                case 7:
                    // Get Report (Print highest note, lowest note, and average of the class using string builder)
                    getReport(studentList);
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                case 9:
                    System.out.println("Please select student:");
                    for(int i = 0; i<studentList.size(); i++) {
                        System.out.println("1. " + studentList.get(i).name);
                    }
                    System.out.println("Introduce student number: ");
                    int a = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Introduce grade X.X: ");
                    double grade = sc.nextDouble();
                    sc.nextLine();

                    studentList.get(a).gradesAL.add(grade);

                    return;

                case 10:
                    System.out.println("Please select student:");
                    for(int i = 0; i<studentList.size(); i++) {
                        System.out.println("1. " + studentList.get(i).name);
                    }
                    System.out.println("Introduce student number: ");
                    int b = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Introduce comment to add: ");
                    String coment = sc.nextLine();
                    sc.nextLine();

                    StringBuilder sb = new StringBuilder();

                    sb.append(studentList.get(b).comment).append(coment);

                    studentList.get(b).comment = sb.toString();

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
        double grade = sc.nextDouble();
        sc.nextLine();
        System.out.println("Introduce initial comment: ");
        String comment = sc.nextLine();
        studentList.add(new Student(name, grade, comment));

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
        double HG = 0;
        supportList.clear();

        for(int i = 0; i< studentList.size();i++) {
            buffer = studentList.get(i);
            if(buffer.grade > HG) {
                HG = buffer.grade;
                supportList.clear();
                supportList.add(buffer);
            } else if (buffer.grade == HG) {
                supportList.add(buffer);
            }
        }

        System.out.println("The Highest grade is a : " + HG);
        System.out.println("By the students:");

        for(int i = 0; i< supportList.size();i++) {
            System.out.println(supportList.get(i).name);
        }
    }

    public static void getLowestNote(Scanner sc, ArrayList<Student> studentList, ArrayList<Student> supportList, Student buffer) {
        double LG = 100;
        supportList.clear();

        for(int i = 0; i< studentList.size();i++) {
            buffer = studentList.get(i);
            if(buffer.grade < LG) {
                LG = buffer.grade;
                supportList.clear();
                supportList.add(buffer);
            } else if (buffer.grade == LG) {
                supportList.add(buffer);
            }
        }

        System.out.println("The Lowest grade is a : " + LG);
        System.out.println("By the students:");

        for(int i = 0; i< supportList.size();i++) {
            System.out.println(supportList.get(i).name);
        }
    }

    public static void getClassAverage(Scanner sc, ArrayList<Student> studentList) {
        double average = 0;

        for(int i = 0; i <  studentList.size(); i++) {
            average = average + studentList.get(i).grade;
        }

        average = average / studentList.size();
        System.out.print("Average class grade: ");
        System.out.println(average);
    }

    public static void getReport(ArrayList<Student> studentList) {
        double HG = 0;
        double LG = 100;
        double gradeSum = 0;

        ArrayList<String> highest = new ArrayList<>();
        ArrayList<String> lowest = new ArrayList<>();
        Student curStudent = null;

        for(int i = 0; i< studentList.size();i++) {
            curStudent = studentList.get(i);
            gradeSum += curStudent.grade;

            if (curStudent.grade > HG) {
                HG = curStudent.grade;
                highest.clear();
                highest.add(curStudent.name);
            } else if (curStudent.grade == HG) {
                highest.add(curStudent.name);
            }

            if  (curStudent.grade < LG) {
                LG = curStudent.grade;
                lowest.clear();
                lowest.add(curStudent.name);
            } else if (curStudent.grade == LG) {
                lowest.add(curStudent.name);
            }
        }

        double averageGrade = gradeSum / studentList.size();

        StringBuilder sb = new StringBuilder();

        sb.append("---Report---\n").append("Highest grade in the class is: ").append(HG).append("\n");
        sb.append("Students with the highest grade are: ").append(highest).append("\n");
        sb.append("Lowest grade in the class is: ").append(LG).append("\n");
        sb.append("Students with the lowest grade are: ").append(lowest).append("\n");
        sb.append("Average grade is a : ").append(String.format("%.4f", averageGrade)).append("\n");

        System.out.println(sb);

    }

}
