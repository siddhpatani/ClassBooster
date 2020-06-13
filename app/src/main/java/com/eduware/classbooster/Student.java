package com.eduware.classbooster;
//comment from ansh
public class Student {

    private boolean outgoing;
    private boolean shy;
    private boolean badEyesight;
    private boolean serious;
    private boolean offTask;
    private String name;

    public Student() {

    }

    public Student(String name) {
        this.setName(name);
    }

    public Student(boolean outgoing, boolean shy, boolean badEyesight, boolean serious, boolean offTask, String name) {
        this.setOutgoing(outgoing);
        this.setShy(shy);
        this.setBadEyesight(badEyesight);
        this.setSerious(serious);
        this.setOffTask(offTask);
        this.setName(name);
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
}
