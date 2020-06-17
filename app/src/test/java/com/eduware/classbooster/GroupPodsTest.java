package com.eduware.classbooster;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupPodsTest {

    @Test
    public void testConstructor1() {
        GroupPods classroom1 = new GroupPods(30, 4, 3);
        assertEquals(3, classroom1.getColCount());
        assertEquals(3, classroom1.getRowCount());
    }

    @Test
    public void testConstructor2() {
        GroupPods classroom2 = new GroupPods(88, 1, 1);
        assertEquals(5, classroom2.getColCount());
        assertEquals(5, classroom2.getRowCount());
    }

    @Test
    public void testConstructor3() {
        GroupPods classroom3 = new GroupPods(29, 2, 1);
        assertEquals(4, classroom3.getColCount());
        assertEquals(2, classroom3.getRowCount());
    }

    @Test
    public void testConstructor4() {
        GroupPods classroom4 = new GroupPods(8, 4, 3);
        assertEquals(2, classroom4.getColCount());
        assertEquals(1, classroom4.getRowCount());
    }

    @Test
    public void testConstructor5() {
        GroupPods classroom5 = new GroupPods(25, 3, 2);
        assertEquals(3, classroom5.getColCount());
        assertEquals(3, classroom5.getRowCount());
    }

    @Test
    public void testArrangeStudents1() {
        GroupPods classroom1 = new GroupPods(30, 4, 3);
        classroom1.arrangeStudents(ClassroomTestUtil.prepareRoster(classroom1.getSize()));

        Assignment[][] chart = classroom1.getChart();
        ClassroomTestUtil.printChart(chart);
    }
}
