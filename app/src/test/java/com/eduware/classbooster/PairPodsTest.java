package com.eduware.classbooster;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PairPodsTest {
    @Test
    public void testConstructor1() {
        PairPods classroom1 = new PairPods(30, 4, 3);
        assertEquals(3, classroom1.getColCount());
        assertEquals(5, classroom1.getRowCount());
    }

    @Test
    public void testConstructor2() {
        PairPods classroom2 = new PairPods(25, 4, 3);
        assertEquals(3, classroom2.getColCount());
        assertEquals(5, classroom2.getRowCount());
    }

    @Test
    public void testConstructor3() {
        PairPods classroom1 = new PairPods(25, 2, 1);
        assertEquals(4, classroom1.getColCount());
        assertEquals(4, classroom1.getRowCount());
    }

    @Test
    public void testConstructor4() {
        PairPods classroom1 = new PairPods(23, 2, 1);
        assertEquals(3, classroom1.getColCount());
        assertEquals(4, classroom1.getRowCount());
    }

    @Test
    public void testArrangeStudents1() {
        PairPods classroom1 = new PairPods(30, 4, 3);
        classroom1.arrangeStudents(ClassroomTestUtil.prepareRoster(classroom1.getSize()));

        Assignment[][] chart = classroom1.getChart();
        ClassroomTestUtil.printChart(chart);
    }

    @Test
    public void testArrangeStudents2() {
        PairPods classroom1 = new PairPods(25, 4, 3);
        classroom1.arrangeStudents(ClassroomTestUtil.prepareRoster(classroom1.getSize()));

        Assignment[][] chart = classroom1.getChart();
        ClassroomTestUtil.printChart(chart);
    }

    @Test
    public void testArrangeStudents3() {
        PairPods classroom1 = new PairPods(23, 2, 1);
        classroom1.arrangeStudents(ClassroomTestUtil.prepareRoster(classroom1.getSize()));

        Assignment[][] chart = classroom1.getChart();
        ClassroomTestUtil.printChart(chart);
    }
}