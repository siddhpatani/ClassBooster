package com.eduware.classbooster;

import java.util.ArrayList;
import java.util.Random;

public class Traditional extends Classroom {

    private final Student[][] chart;

    // precondition: students.size() >= depth
    public Traditional(int studentCount, double span, double depth) {
        double skew = (double) studentCount / span / depth;
        final int rows = (int) Math.ceil(span * Math.sqrt(skew));
        final int cols = (int) Math.ceil(depth * Math.sqrt(skew));
        chart = new Student[rows][cols];
    }

    public int getRowCount() {
        return chart.length;
    }

    public int getColCount() {
        return chart[0].length;
    }

    // postcondition: students.size() > 0
    @Override
    public void arrangeStudents(ArrayList<Student> students) {
        Random r = new Random();
        // Make a copy of students in a randomized order so that we don't damage the list as we assign them to seats
        final ArrayList<Student> randStudents = new ArrayList<Student>(students.size());
        for (int i = 0; i < students.size(); i++) {
            int randomNumber = r.nextInt(students.size());
            randStudents.set(i, students.get(randomNumber));
        }

        for (int col = 0; col < chart[0].length; col++) {
            int selection = r.nextInt(randStudents.size());
            chart[0][col] = randStudents.remove(selection);
        }

        boolean eyesightMatters = true;
        for (int row = 0; row < chart.length; row++) {
            for (int col = 1; col < chart[0].length; col++) {
                chart[row][col] = this.findPartner(randStudents, chart[row][col - 1], eyesightMatters);
                if (chart[row][col] == null) {
                    if (randStudents.size() > 0 && row < 2) {
                        chart[row][col] = this.findPartner(randStudents, chart[row][col - 1], false);
                    } else break;
                }
                randStudents.remove(chart[row][col]);
            }
            if (row > 1)
                eyesightMatters = false;
        }
    }
}
