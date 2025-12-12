package org.example;

import java.util.ArrayList;

public class Student {
    String name;
    ArrayList<Double> gradesAL = new ArrayList<>();
    String comment;

    public Student(String name, ArrayList<Double> grades,  String comment) {
        this.name = name;
        this.gradesAL = grades;
        this.comment = comment;
    }

    // Returns Highest grade of a student, -1.0 means no grades were stored
    public Double highestGrade() {
        Double highestGrade = -1.0;

        for(int i = 0; i< gradesAL.size(); i++) {
            if (gradesAL.get(i) > highestGrade) {
                highestGrade = gradesAL.get(i);
            }
        }

        return highestGrade;
    }

    // Returns Lowest grade of a Student, 1000000000.0 means no grades
    public Double lowestGrade() {
        Double lowestGrade = 1000000000000.0;

        for(int i = 0; i< gradesAL.size(); i++) {
            if (gradesAL.get(i) < lowestGrade) {
                lowestGrade = gradesAL.get(i);
            }
        }

        return lowestGrade;
    }

    // Returns Students grade average, -1.0 if no grades are stored
    public Double average() {
        Double average = -1.0;

        if(gradesAL.size() > 0) {
            average = 0.0;
            for(int i = 0; i< gradesAL.size(); i++) {
                average = average + gradesAL.get(i);
            }
            average = average/gradesAL.size();
        }

        return average;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Strudents name: ").append(name).append("\nStudent's grade: ").append(gradesAL.toString()).append("\nComment: ").append(comment);
        return sb.toString();
    }
}
