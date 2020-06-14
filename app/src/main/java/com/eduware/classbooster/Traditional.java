package com.eduware.classbooster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Traditional extends Classroom {

    private final Student[][] chart;

    private final int capacity;

    private int size;

    // precondition: studentCount >= depth && studentCount > 0
    public Traditional(int studentCount, double span, double depth) {
        double skew = (double) studentCount / span / depth;
        final int rows = (int) Math.ceil(depth * Math.sqrt(skew));
        final int cols = (int) Math.ceil(span * Math.sqrt(skew));
        chart = new Student[rows][cols];
        capacity = rows * cols;
        size = studentCount;
    }

    public int getRowCount() {
        return chart.length;
    }

    public int getColCount() {
        return chart[0].length;
    }

    @Override
    protected int getSize() {
        return size;
    }

    public Student[][] getChart() {
        return chart;
    }

    // precondition: for any students.get(i), student.getName() != null && !student.getName().equals("")
    // postcondition: students.size() > 0 studentCount == students.size()
    @Override
    public void arrangeStudents(List<Student> students) {
        Random r = new Random();
        // Make a copy of students in a randomized order so that we don't damage the list as we assign them to seats
        final ArrayList<Student> randStudents = new ArrayList<Student>(students);
        for (int i = 0; i < students.size(); i++) {
            int randomNumber = r.nextInt(students.size() - 1);
            randStudents.add(r.nextInt(students.size()), randStudents.remove(randomNumber));
        }

        // we want to fill the first seat in each row
        for (int row = 0; row < chart.length; row++) {
            int selection = r.nextInt(randStudents.size());
            chart[row][0] = randStudents.remove(selection);
        }

        boolean eyesightMatters = true;
        for (int row = 0; row < chart.length; row++) {
            for (int col = 1; col < chart[0].length; col++) {
                if (chart[row][col - 1] == null) break;
                chart[row][col] = this.findPartner(randStudents, chart[row][col - 1], eyesightMatters);
                if (chart[row][col] == null) {
                    if (randStudents.size() > 0 && row < 2) {
                        chart[row][col] = this.findPartner(randStudents, chart[row][col - 1], false);
                    } else break;
                }
                randStudents.remove(chart[row][col]);
            }
            if (row >= 1)
                eyesightMatters = false;
        }
        centerLastRow();
    }

    private void centerLastRow() {
        int holes = getRowCount() * getColCount() - getSize();
        if (holes < 2) return;
        int left = holes / 2;
        int right = holes - left;
        for (int i = 0; i < left; i++) {
            chart[chart.length - 1][left + i] = chart[chart.length - 1][i];
            chart[chart.length - 1][i] = null;
        }
    }
}
