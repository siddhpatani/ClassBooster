package com.eduware.classbooster;

public class Pair implements Assignment {

    private Student left;
    private Student right;

    public Pair(Student left, Student right) {
        setLeft(left);
        setRight(right);
    }


    public Student getLeft() {
        return left;
    }

    public void setLeft(Student left) {
        this.left = left;
    }

    public Student getRight() {
        return right;
    }

    public void setRight(Student right) {
        this.right = right;
    }

    public String toString() {
        return "[" + getLeft() + " " + getRight() + "]";
    }
}
