package com.eduware.classbooster;
import java.util.ArrayList;
public class Names {
    protected ArrayList <Student> names = new ArrayList<Student>();

    public Names(){
        names = new ArrayList<Student>();
    }
    public ArrayList <Student> getNames(){
        return names;
    }

    public Names(ArrayList <Student> students){
        /*
        for(int i = 0; i < students.size(); i++){
            Student s = students.get(i);
            String studentName = s.getName();
            this.names.add(studentName);
        }
        */
        names = students;
    }

    public void addName(String n){
        Student student = new Student(n);
        this.names.add(student);
    }

    public void addNames(ArrayList <Student> names){
        int l = names.size();
        for(int i = 0; i<l; i++) {
            this.names.add(names.get(i));
        }
    }

    public Student getStudent(String name){
        for(int i = 0; i < names.size(); i++){
            Student currentStudent = names.get(i);
            String currentName = currentStudent.getName();
            if(currentName != null){
                if(currentName == name){
                    return currentStudent;
                }
            }
        }
        return null;
    }

}
