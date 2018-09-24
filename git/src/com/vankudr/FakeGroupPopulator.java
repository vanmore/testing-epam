package com.vankudr;

import java.util.ArrayList;
import java.util.Arrays;

public class FakeGroupPopulator {

    FakeGroupPopulator() {}

    FakeGroupPopulator(StudyGroup group) {
        populate(group);
    }

    public void populate(StudyGroup group) {
        Student stud;

        stud = new Student("Vlad", "Pushkin");
        stud.setMarks(new ArrayList<Integer>(Arrays.asList(8,8,9,9)));
        group.addStudent(stud);

        stud = new Student("Max", "Pereshkin");
        stud.setMarks(new ArrayList<Integer>(Arrays.asList(6,4,6,5)));
        group.addStudent(stud);

        stud = new Student("Semen", "Kulikov");
        stud.setMarks(new ArrayList<Integer>(Arrays.asList(6,8,9,7)));
        group.addStudent(stud);

        stud = new Student("Dimiter", "Fasanoff");
        stud.setMarks(new ArrayList<Integer>(Arrays.asList(10,10,9,9)));
        group.addStudent(stud);

        stud = new Student("Maxim", "Peperev");
        stud.setMarks(new ArrayList<Integer>(Arrays.asList(4,4,5,4)));
        group.addStudent(stud);

        stud = new Student("Artem", "Udodov");
        stud.setMarks(new ArrayList<Integer>(Arrays.asList(4,4,5,4)));
        group.addStudent(stud);
    };
}
