package com.exercise.ex3_student.controller;

import com.exercise.ex3_student.model.Student;
import com.exercise.ex3_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Accueil");
        return "home";
    }

    @GetMapping("/student-list")
    public String studentList(Model model) {
        model.addAttribute("title", "Liste des étudiants");
        model.addAttribute("list", studentService.getStudents());
        return "studentList";
    }

    @GetMapping("/student")
    public String studentSearch(@RequestParam(value = "search") String searchValue, Model model) {
        model.addAttribute("title", "Résultat pour \" " + searchValue + " \"");
        model.addAttribute("list", studentService.getStudentsByPartialName(searchValue));
        return "studentList";
    }

    @GetMapping("/student/{id}")
    public String studentDetail(@PathVariable int id, Model model) {
        model.addAttribute("title", "Détails");
        model.addAttribute("student", studentService.getStudentById(id));
        return "studentDetail";
    }

    @GetMapping("/student-new")
    public String newStudent(Model model) {
        model.addAttribute("title", "Inscription");
        model.addAttribute("student", new Student());
        model.addAttribute("mode", "create");
        return "newStudent";
    }

    @PostMapping("/student-new")
    public String submitStudent(@ModelAttribute("student") Student student) {
        if (student.getId() == 0) studentService.addStudent(student);
        else studentService.updateStudent(student);
        return "redirect:/student-list";
    }

    @GetMapping("/student-remove")
    public String removeStudent(@RequestParam(value = "studentId") int id) {
        studentService.deleteStudentById(id);
        return "redirect:/student-list";
    }

    @GetMapping("/student-update")
    public String updateStudent(@RequestParam(value = "studentId") int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("title", "Modification");
        model.addAttribute("student", student);
        model.addAttribute("mode", "update");
        return "newStudent";
    }

}
