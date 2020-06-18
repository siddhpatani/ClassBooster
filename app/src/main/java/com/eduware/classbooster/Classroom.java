package com.eduware.classbooster;

import java.util.List;
import java.util.Random;

public abstract class Classroom {

    protected Assignment[][] chart;
    protected int capacity;
    protected int size;

    protected RoomInfo roomInfo;

    public Classroom(int studentCount) {
        size = studentCount;
    }

    public int getRowCount() {
        return chart.length;
    }

    public int getColCount() {
        return chart[0].length;
    }

    protected int getSize() {
        return size;
    }

    protected Student findPartner(List<Student> unassigned, Student given, boolean eyesightMatters) {
        for (int priority = 1; priority <= 4; priority++)
            for (Student s : unassigned)
                if (given.isCompatible(s, eyesightMatters, priority)) return s;
        return /*!eyesightMatters &&*/ unassigned.size() > 0 ? unassigned.get(0) : null;
    }

    protected void shuffle(List<Student> students) {
        Random r = new Random();
        for (int i = 0; i < students.size(); i++)
            students.add(r.nextInt(students.size()), students.remove(r.nextInt(students.size() - 1)));
    }

    public Assignment[][] getChart() {
        return chart;
    }

    public abstract void arrangeStudents(List<Student> students);

    protected void centerLastRow() {
        int holes = 0;
        for (Assignment a : chart[chart.length - 1])
            if (a == null) holes++;
        if (holes < 2) return;
        int left = holes / 2;
        int right = holes - left;
        for (int i = 0; i < left; i++) {
            chart[chart.length - 1][left + i] = chart[chart.length - 1][i];
            chart[chart.length - 1][i] = null;
        }
    }

    public RoomInfo getRoomInfo(){
        return roomInfo;
    }

    public void setRoomInfo(RoomInfo r){
        roomInfo = r;
    }
}