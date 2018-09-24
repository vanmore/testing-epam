package com.vankudr;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private List<Integer> marks;

    Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        marks = new ArrayList<Integer>();
    }

    public String updateFirstName() {
        return firstName;
    }

    public void updateFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public void addMark(int markToAdd) {
        marks.add(markToAdd);
    }

    public double getAverageMark() {
        double average = 0;
        int counter = 0;
        for(int mark: marks) {
            average += mark;
            counter++;
        }
        if (counter != 0) {
            return average/counter;
        }

        return 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstName);
        stringBuilder.append(" ");
        stringBuilder.append(lastName);
        stringBuilder.append(":  ");

        for(int mark: marks) {
            stringBuilder.append(mark);
            stringBuilder.append(" ");
        }

        stringBuilder.append(" average: ");
        stringBuilder.append(getAverageMark());

        return stringBuilder.toString();
    }
}
