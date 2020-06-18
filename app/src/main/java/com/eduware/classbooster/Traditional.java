package com.eduware.classbooster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Traditional extends Classroom {

    // precondition: studentCount >= depth && studentCount > 0
    public Traditional(int studentCount, double span, double depth) {

        super(studentCount);
        double skew = (double) studentCount / span / depth;
        final int rows = (int) Math.ceil(depth * Math.sqrt(skew));
        final int cols = (int) Math.ceil(span * Math.sqrt(skew));
        chart = new Student[rows][cols];
        capacity = rows * cols;
    }

    // precondition: for any students.get(i), student.getName() != null && !student.getName().equals("")
    // postcondition: students.size() > 0 studentCount == students.size()
    @Override
    public void arrangeStudents(List<Student> students) {

        Random r = new Random();
        List<Student> randStudents = new ArrayList<Student>(students);
        shuffle(randStudents);

        // we want to fill the first seat in each row
        for (int row = 0; row < getRowCount(); row++) {
            int selection;
            do {
                selection = r.nextInt(randStudents.size());
            } while (randStudents.get(selection).hasBadEyesight());
            getChart()[row][0] = randStudents.remove(selection);
        }

        boolean eyesightMatters = true;
        for (int row = 0; row < getRowCount(); row++) {
            for (int col = 1; col < getColCount(); col++) {
                if (getChart()[row][col - 1] == null) break;
                getChart()[row][col] = this.findPartner(randStudents, (Student) getChart()[row][col - 1], eyesightMatters);
                if (getChart()[row][col] == null) {
                    if (randStudents.size() > 0 && row < 2) {
                        getChart()[row][col] = this.findPartner(randStudents, (Student) getChart()[row][col - 1], false);
                    } else break;
                }
                randStudents.remove((Student) getChart()[row][col]);
            }
            if (row >= 1)
                eyesightMatters = false;
        }
        centerLastRow();
    }

}
