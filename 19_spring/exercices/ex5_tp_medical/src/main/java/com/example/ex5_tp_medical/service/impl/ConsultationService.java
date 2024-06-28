package com.example.ex5_tp_medical.service.impl;

import com.example.ex5_tp_medical.model.Consultation;
import com.example.ex5_tp_medical.model.Patient;
import com.example.ex5_tp_medical.service.IConsultationService;

import java.util.ArrayList;
import java.util.List;

public class ConsultationService implements IConsultationService {
    private final List<Consultation> consultations;

    private int cntConsultations = 0;

    public ConsultationService() {
        consultations = new ArrayList<>();
    }

    @Override
    public void saveConsultation(Consultation consultation, Patient patient) {
        consultation.setId(++cntConsultations);
        patient.getConsultations().add(consultation);
        consultations.add(consultation);
    }

    @Override
    public List<Consultation> getConsultationByPatient(Patient patient) {
        return patient.getConsultations();
    }
}
