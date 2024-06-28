package com.example.ex5_tp_medical.service;

import com.example.ex5_tp_medical.model.Consultation;
import com.example.ex5_tp_medical.model.Patient;

import java.util.List;

public interface IConsultationService {
    void saveConsultation(Consultation consultation, Patient patient);
    List<Consultation> getConsultationByPatient(Patient patient);
}
