package com.eduware.classbooster;

import java.util.ArrayList;

public abstract class Classroom {
    protected Student findPartner(ArrayList<Student> unassigned, Student given, boolean eyesightMatters){
        for (int priority = 1; priority <= 4; priority++) for (Student s: unassigned) if (given.isCompatible(s, eyesightMatters, priority)) return s;
        return !eyesightMatters && unassigned.size() > 0 ? unassigned.get(0) : null;
    }

    public abstract void arrangeStudents(ArrayList<Student> students);
}
