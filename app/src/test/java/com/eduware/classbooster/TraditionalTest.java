package com.eduware.classbooster;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TraditionalTest {

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
        classroom1.arrangeStudents(ClassroomTestUtil.prepareRoster(classroom1.getSize()));

        Assignment[][] chart = classroom1.getChart();
        ClassroomTestUtil.printChart(chart);
    }

    @Test
    public void testArrangeStudents2() {
        Traditional classroom1 = new Traditional(25, 4, 3);
        classroom1.arrangeStudents(ClassroomTestUtil.prepareRoster(classroom1.getSize()));

        Assignment[][] chart = classroom1.getChart();
        ClassroomTestUtil.printChart(chart);
    }

    @Test
    public void testArrangeStudents3() {
        Traditional classroom1 = new Traditional(25, 3, 1);
        classroom1.arrangeStudents(ClassroomTestUtil.prepareRoster(classroom1.getSize()));

        Assignment[][] chart = classroom1.getChart();
        ClassroomTestUtil.printChart(chart);
    }


}
