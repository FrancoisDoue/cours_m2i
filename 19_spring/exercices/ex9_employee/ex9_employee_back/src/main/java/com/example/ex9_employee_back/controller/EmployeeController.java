package com.example.ex9_employee_back.controller;

import com.example.ex9_employee_back.dto.absence.AbsencePostDTO;
import com.example.ex9_employee_back.dto.employee.EmployeeGetDTO;
import com.example.ex9_employee_back.dto.employee.EmployeePostDTO;
import com.example.ex9_employee_back.dto.recruitment.RecruitmentPostDTO;
import com.example.ex9_employee_back.entity.Employee;
import com.example.ex9_employee_back.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeGetDTO>> getAllEmployees() {
        return ResponseEntity.ok()
                .body(employeeService.getAllEmployees().stream().map(EmployeeGetDTO::new).toList());
    }

    @PostMapping
    public ResponseEntity<EmployeeGetDTO> addEmployee(@RequestBody EmployeePostDTO employeePost) {
        Employee employee = employeeService.createEmployee(employeePost);
        return new ResponseEntity<>(new EmployeeGetDTO(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeGetDTO> getEmployee(@PathVariable int id) {
        return ResponseEntity.ok().body(new EmployeeGetDTO(employeeService.getEmployeeById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeGetDTO> updateEmployee(@PathVariable int id, @RequestBody EmployeePostDTO employeePost) {
        Employee employee = employeeService.updateEmployee(id, employeePost);
        return ResponseEntity.ok().body(new EmployeeGetDTO(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}/absence")
    public ResponseEntity<EmployeeGetDTO> absenceEmployee(@PathVariable int id, @RequestBody AbsencePostDTO absencePost) {
        Employee employee = employeeService.addAbsenceToEmployee(id, absencePost);
        return new ResponseEntity<>(new EmployeeGetDTO(employee), HttpStatus.CREATED);
    }

    @PostMapping("/recruit/{candidateId}")
    public ResponseEntity<EmployeeGetDTO> recruitEmployee(@PathVariable int candidateId, @RequestBody RecruitmentPostDTO recruitmentPostDTO) {
        Employee employee = employeeService.recruitCandidate(candidateId, recruitmentPostDTO);
        return new ResponseEntity<>(new EmployeeGetDTO(employee), HttpStatus.CREATED);
    }

}
