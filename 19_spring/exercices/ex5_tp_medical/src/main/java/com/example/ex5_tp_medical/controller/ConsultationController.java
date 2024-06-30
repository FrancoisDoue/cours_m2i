package com.example.ex5_tp_medical.controller;

import com.example.ex5_tp_medical.model.Consultation;
import com.example.ex5_tp_medical.model.Patient;
import com.example.ex5_tp_medical.service.impl.ConsultationService;
import com.example.ex5_tp_medical.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/consultations")
public class ConsultationController {

    private final ConsultationService consultationService;
    private final PatientService patientService;

    @Autowired
    public ConsultationController(ConsultationService consultationService, PatientService patientService) {
        this.consultationService = consultationService;
        this.patientService = patientService;
    }

    @PostMapping
    public String addConsultation(Consultation consultation, Patient patient) {
        System.out.println("On add consultation");
        consultationService.saveConsultation(consultation, patientService.getPatientById(patient.getId()));
        System.out.println(consultation);
        return "redirect:/patients/" + patient.getId();
    }

    @GetMapping("/new/{id}")
    public String newConsultation(@PathVariable int id, Model model) {
        model.addAttribute("consultation", new Consultation());
        model.addAttribute("patient", patientService.getPatientById(id));
        return "consultation-form";
    }


}
