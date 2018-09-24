package com.vankudr;

import java.util.ArrayList;
import java.util.List;

public class StudyGroup {
    private String groupName;
    private List<Student> students;

    public String getGroupName() {
        return groupName;
    }

    public void changeGroupName(String groupName) {
        this.groupName = groupName;
    }


    public void addStudent(Student student) {
        this.students.add(student);
    }

    public StudyGroup(String groupName) {
        this.groupName = groupName;
        students = new ArrayList<Student>();
    }

    public double getAverageMark() {
        double result = 0;
        int counter = 0;
        for(Student stud: students) {
            result += stud.getAverageMark();
            counter++;
        }
        if(counter != 0) {
            return result/counter;
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Group ");
        stringBuilder.append(groupName);
        stringBuilder.append('\n');
        for(Student stud: students) {
            stringBuilder.append(stud.toString());
            stringBuilder.append('\n');
        }
        stringBuilder.append("--------------");
        stringBuilder.append("\naverage mark in group: ");
        stringBuilder.append(getAverageMark());
        return stringBuilder.toString();
    }
}
