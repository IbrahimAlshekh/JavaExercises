package com.alshekh.JavaExcercises.CourseManager;

import java.util.ArrayList;

public class Trainee {
    private int Id;
    private String name;
    private int age;
    private ArrayList<Course> courses;

    public Trainee() {
        this.courses = new ArrayList<>();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void assignACourse(Course course)
    {
        this.courses.add(course);
    }
}
