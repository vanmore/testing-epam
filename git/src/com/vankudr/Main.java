package com.vankudr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        StudyGroup group9 = new StudyGroup("9");

        FakeGroupPopulator fakeGroupPopulator = new FakeGroupPopulator();
        fakeGroupPopulator.populate(group9);

        System.out.println(group9.toString());

    }
}
