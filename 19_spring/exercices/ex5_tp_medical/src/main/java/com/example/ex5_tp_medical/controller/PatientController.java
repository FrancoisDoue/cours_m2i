package com.example.ex5_tp_medical.controller;

import com.example.ex5_tp_medical.model.Patient;
import com.example.ex5_tp_medical.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public String getPatients(@RequestParam(name = "search", required = false) String searchValue, Model model) {
        model.addAttribute(
                "patientList",
                searchValue != null ? patientService.getPatientsByName(searchValue) : patientService.getAllPatients()
        );
        return "patient-list";
    }

    @PostMapping
    public String addPatient(Patient patient) {
        if (patient.getId() == 0)
            patientService.savePatient(patient);
        else
            patientService.updatePatient(patient);
        return "redirect:/patients";
    }


    @GetMapping("/{id}")
    public String getPatient(@PathVariable int id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "patient-detail";
    }

    @GetMapping("/new")
    public String newPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-form";
    }

    @GetMapping("/update/{id}")
    public String updatePatient(@PathVariable int id, Model model) {
        model.addAttribute("patient", patientService.getPatientById(id));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return "patient-form";
    }


}
