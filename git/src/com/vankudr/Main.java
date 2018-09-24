package com.vankudr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //create group 9
        StudyGroup group9 = new StudyGroup("9");

        //populating created group with fake students
        FakeGroupPopulator fakeGroupPopulator = new FakeGroupPopulator();
        fakeGroupPopulator.populate(group9);

        //print marks and avearage marks for every student and for group
        System.out.println(group9.toString());
    }
}
