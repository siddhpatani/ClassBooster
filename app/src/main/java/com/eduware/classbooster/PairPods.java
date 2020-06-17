package com.eduware.classbooster;

import java.util.ArrayList;
import java.util.List;

public class PairPods extends Classroom {

    // precondition: studentCount >= depth && studentCount > 0
    public PairPods(int studentCount, int span, int depth) {
        super(studentCount);
        double skew = (double) studentCount / span / depth;
        int rows = (int) Math.ceil(depth * Math.sqrt(skew));
        int cols = (int) Math.ceil(span * Math.sqrt(skew)) / 2;
        if (rows * cols * 2 < studentCount) cols++;
        chart = new Pair[rows][cols];
        capacity = rows * cols;
        size = studentCount;
    }

    @Override
    public void arrangeStudents(List<Student> students) {
        List<Student> randStudents = new ArrayList<Student>(students);
        shuffle(randStudents);
        boolean eyesightMatters = true;
        for (int row = 0; row < chart.length; row++) {
            for (int col = 0; col < chart[0].length; col++) {
                int selection;
                for (selection = 0; eyesightMatters && selection < randStudents.size() && !randStudents.get(selection).hasBadEyesight(); selection++)
                    ;
                if (selection == randStudents.size())
                    if (randStudents.size() > 0) selection = 0;
                    else break;
                chart[row][col] = new Pair(randStudents.remove(selection), null);
                ((Pair) chart[row][col]).setRight(this.findPartner(randStudents, ((Pair) chart[row][col]).getLeft(), eyesightMatters));
                randStudents.remove(((Pair) chart[row][col]).getRight());
            }
            if (row >= 1)
                eyesightMatters = false;
        }
        centerLastRow();
    }
}
