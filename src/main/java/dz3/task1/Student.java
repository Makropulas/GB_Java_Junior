package dz3.task1;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.*;

public class Student implements Serializable{
    @Serial
    private static final long serialVersionUID = 1;
    private String name;
    private int age;
    @JsonIgnore
    private transient double GPA;

    public Student() {
    }

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @JsonIgnore
    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}
