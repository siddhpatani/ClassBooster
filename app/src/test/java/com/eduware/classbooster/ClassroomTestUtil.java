package com.eduware.classbooster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassroomTestUtil {
    private final static Random randomizer = new Random();
    private static String nextName = "A";

    static List<Student> prepareRoster(int count) {
        List<Student> roster = new ArrayList<Student>(count);
        for (int i = 0; i < count; i++) {
            roster.add(getRandomStudent());
        }
        return roster;
    }

    static Student getRandomStudent() {
        boolean eyesight = randomizer.nextInt(4) > 2;
        boolean shy = randomizer.nextBoolean();
        boolean serious = randomizer.nextBoolean();
        return new Student(generateStudentName(), eyesight, !shy, shy, serious, !serious);
    }

    static String generateStudentName() {
        String name = nextName;
        char nextChar = (char) (nextName.charAt(nextName.length() - 1) + 1);
        if (nextChar > 'Z') {
            nextName = "AA";
            nextChar = 'A';
        }
        nextName = nextName.substring(0, nextName.length() - 1) + nextChar;
        return name;
    }

    static void printChart(Assignment[][] chart) {
        for (Assignment[] row : chart) {
            for (Assignment a : row) {
                System.out.print(a + "\t");
            }
            System.out.println("\n");
        }
    }
}
