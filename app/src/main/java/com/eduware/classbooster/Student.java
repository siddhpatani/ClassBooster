package com.eduware.classbooster;
//comment from ansh
public class Student implements Assignment {

    private boolean outgoing;
    private boolean shy;
    private boolean badEyesight;
    private boolean serious;
    private boolean offTask;
    private String name;


    public Student(String name) {
        this.setName(name);
    }

    public Student(String name, boolean badEyesight, boolean outgoing, boolean shy, boolean serious, boolean offTask) {
        this(name);
        this.setOutgoing(outgoing);
        this.setShy(shy);
        this.setBadEyesight(badEyesight);
        this.setSerious(serious);
        this.setOffTask(offTask);
    }


    public boolean isOutgoing() {
        return outgoing;
    }

    public void setOutgoing(boolean outgoing) {
        this.outgoing = outgoing;
    }

    public boolean isShy() {
        return shy;
    }

    public void setShy(boolean shy) {
        this.shy = shy;
    }

    public boolean hasBadEyesight() {
        return badEyesight;
    }

    public void setBadEyesight(boolean badEyesight) {
        this.badEyesight = badEyesight;
    }

    public boolean isSerious() {
        return serious;
    }

    public void setSerious(boolean serious) {
        this.serious = serious;
    }

    public boolean isOffTask() {
        return offTask;
    }

    public void setOffTask(boolean offTask) {
        this.offTask = offTask;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompatible(Student other, int priority) {
        switch (priority) {
            case 1:
                return this.isSerious() && other.isOffTask() ||
                        this.isShy() && other.isOutgoing() ||
                        this.isOutgoing() && this.isShy() ||
                        this.isOffTask() && this.isSerious();
            case 2:
                return this.isSerious() && other.isOutgoing() ||
                        this.isShy() && other.isSerious() ||
                        this.isOutgoing() && this.isOffTask() ||
                        this.isOffTask() && this.isOutgoing();
            case 3:
                return this.isSerious() && other.isShy() ||
                        this.isShy() && other.isShy() ||
                        this.isOutgoing() && this.isSerious() ||
                        this.isOffTask() && this.isShy();
            default:
                return this.isSerious() && other.isSerious() ||
                        this.isOutgoing() && this.isOutgoing();
        }
    }

    public boolean isCompatible(Student other, boolean eyesightMatters, int priority) {
        return eyesightMatters && other.hasBadEyesight() && isCompatible(other, priority) ||
                !eyesightMatters && isCompatible(other, priority);
    }

    @Override
    public String toString() {
        return name + (badEyesight ? "_" : " ") + (serious ? "s" : " ") + (shy ? "h" : " ") + (outgoing ? "o" : " ") + (offTask ? "t" : " ");
    }
}
