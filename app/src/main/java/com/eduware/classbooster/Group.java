package com.eduware.classbooster;

public class Group implements Assignment {

    private Student s1;
    private Student s2;
    private Student s3;
    private Student s4;

    public Group(Student topLeft, Student topRight, Student bottomLeft, Student bottomRight) {
        this.setS1(topLeft);
        this.setS2(topRight);
        this.setS3(bottomLeft);
        this.setS4(bottomRight);
    }

    public Student getS1() {
        return s1;
    }

    public void setS1(Student s1) {
        this.s1 = s1;
    }

    public Student getS2() {
        return s2;
    }

    public void setS2(Student s2) {
        this.s2 = s2;
    }

    public Student getS3() {
        return s3;
    }

    public void setS3(Student s3) {
        this.s3 = s3;
    }

    public Student getS4() {
        return s4;
    }

    public void setS4(Student s4) {
        this.s4 = s4;
    }

    public String toString() {
        return "[" + s1 + " " + s2 + "]\n[" + s4 + " " + s3 + "]";
    }
}
