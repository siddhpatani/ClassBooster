package com.eduware.classbooster;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class TraditionalTest {
    private final Random randomizer = new Random();
    private String nextName = "A";

    @Test
    public void testConstructor1() {
        Traditional classroom1 = new Traditional(30, 4, 3);
        assertEquals(7, classroom1.getColCount());
        assertEquals(5, classroom1.getRowCount());
    }

    @Test
    public void testConstructor2() {
        Traditional classroom2 = new Traditional(25, 4, 3);
        assertEquals(6, classroom2.getColCount());
        assertEquals(5, classroom2.getRowCount());
    }

    @Test
    public void testConstructor3() {
        Traditional classroom1 = new Traditional(25, 2, 1);
        assertEquals(8, classroom1.getColCount());
        assertEquals(4, classroom1.getRowCount());
    }

    @Test
    public void testArrangeStudents1() {
        Traditional classroom1 = new Traditional(30, 4, 3);
        classroom1.arrangeStudents(prepareRoster(classroom1.getSize()));

        Student[][] chart = classroom1.getChart();
        printChart(chart);
    }

    @Test
    public void testArrangeStudents2() {
        Traditional classroom1 = new Traditional(25, 4, 3);
        classroom1.arrangeStudents(prepareRoster(classroom1.getSize()));

        Student[][] chart = classroom1.getChart();
        printChart(chart);
    }

    @Test
    public void testArrangeStudents3() {
        Traditional classroom1 = new Traditional(25, 3, 1);
        classroom1.arrangeStudents(prepareRoster(classroom1.getSize()));

        Student[][] chart = classroom1.getChart();
        printChart(chart);
    }

    private void printChart(Student[][] chart) {
        for (Student[] row : chart) {
            for (Student s : row) {
                System.out.print(s + "\t");
            }
            System.out.println("\n");
        }
    }

    private List<Student> prepareRoster(int count) {
        List<Student> roster = new ArrayList<Student>(count);
        for (int i = 0; i < count; i++) {
            roster.add(getRandomStudent());
        }
        return roster;
    }

    private Student getRandomStudent() {
        boolean eyesight = randomizer.nextInt(4) > 2;
        boolean shy = randomizer.nextBoolean();
        boolean serious = randomizer.nextBoolean();
        return new Student(generateStudentName(), eyesight, !shy, shy, serious, !serious);
    }

    private String generateStudentName() {
        String name = nextName;
        char nextChar = (char) (nextName.charAt(nextName.length() - 1) + 1);
        if (nextChar > 'Z') {
            nextName = "AA";
            nextChar = 'A';
        }
        nextName = nextName.substring(0, nextName.length() - 1) + nextChar;
        return name;
    }
}
