package com.eduware.classbooster;

import java.util.List;

public abstract class Classroom {

    protected abstract int getSize();

    protected Student findPartner(List<Student> unassigned, Student given, boolean eyesightMatters) {
        for (int priority = 1; priority <= 4; priority++)
            for (Student s : unassigned)
                if (given.isCompatible(s, eyesightMatters, priority)) return s;
        return !eyesightMatters && unassigned.size() > 0 ? unassigned.get(0) : null;
    }

    public abstract void arrangeStudents(List<Student> students);
}