package org.poo_exercices.exceptions;

public class Student {
    private int age;
    private String name;

    public Student(int age, String name) throws InvalidAgeException {
        this.setAge(age);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) throw new InvalidAgeException("Invalid age");
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
