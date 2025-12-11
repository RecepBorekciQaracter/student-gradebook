package org.example;

public class Student {
    String name;
    double grade;
    String comment;

    public Student(String name, double grade,  String comment) {
        this.name = name;
        this.grade = grade;
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Strudents name: ").append(name).append("\nStudent's grade: ").append(String.valueOf(grade)).append("\nComment: ").append(comment);
        return sb.toString();
    }
}
