package com.eduware.classbooster;

import java.util.ArrayList;
import java.util.List;

public class GroupPods extends Classroom {

    public GroupPods(int studentCount, int span, int depth) {
        super(studentCount);
        double skew = (double) studentCount / span / depth;
        int rows = (int) Math.ceil(depth * Math.sqrt(skew)) / 2;
        int cols = (int) Math.ceil(span * Math.sqrt(skew)) / 2;
        if (rows * cols * 4 < studentCount) rows++;
        if (rows * cols * 4 < studentCount) cols++;
        chart = new Group[rows][cols];
        capacity = rows * cols;
        size = studentCount;
    }

    @Override
    public void arrangeStudents(List<Student> students) {

        List<Student> randStudents = new ArrayList<Student>(students);
        shuffle(randStudents);

        int groupsOfThree = 4 - randStudents.size() % 4, groupsOfFour = (randStudents.size() - groupsOfThree * 3) / 4, threeCount = 0, fourCount = 0;
        boolean eyesightMatters = true;
        for (int row = 0; row < getColCount(); row++) {
            for (int col = 0; col < getRowCount(); col++) {

                Student s1 = randStudents.remove(0);
                chart[row][col] = new Group(s1, null, null, null);
                Student s2 = findPartner(randStudents, s1, eyesightMatters);
                ((Group) chart[row][col]).setS2(s2);
                randStudents.remove(((Group) getChart()[row][col]).getS2());
                Student s3 = findPartner(randStudents, s2, eyesightMatters);
                ((Group) chart[row][col]).setS3(s3);
                randStudents.remove(((Group) getChart()[row][col]).getS3());
                if (fourCount < groupsOfFour) {
                    ((Group) chart[row][col]).setS4(findPartner(randStudents, s3, eyesightMatters));
                    randStudents.remove(((Group) getChart()[row][col]).getS4());
                    fourCount++;
                } else threeCount++;
                if (threeCount + fourCount == groupsOfFour + groupsOfThree) break;
            }
            eyesightMatters = false;
        }
        centerLastRow();
    }
}