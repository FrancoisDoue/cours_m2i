package com.exercise.ex3_student.service;

import com.exercise.ex3_student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private static int cntStudent = 0;
    private static final List<Student> students = new ArrayList<>(List.of());

    public StudentService() {
        addStudent(Student.builder().firstname("Georges").lastname("Abitbol").age(72).email("gabitbol@mail.fr").build());
        addStudent(Student.builder().firstname("test").lastname("test").age(18).email("test@mail.fr").build());
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(int id) {
        return students.stream().filter(student -> student.getId() == id).findFirst().orElse(null);
    }

    public void addStudent(Student student) {
        student.setId(++cntStudent);
        students.add(student);
    }

    public List<Student> getStudentsByPartialName(String name) {
        return students.stream().filter(s -> s.getLastname().toLowerCase().contains(name.toLowerCase())).toList();
    }

}
