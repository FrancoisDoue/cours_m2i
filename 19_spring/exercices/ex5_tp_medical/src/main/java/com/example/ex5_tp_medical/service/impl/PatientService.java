package com.example.ex5_tp_medical.service.impl;

import com.example.ex5_tp_medical.model.Consultation;
import com.example.ex5_tp_medical.model.Patient;
import com.example.ex5_tp_medical.service.IPatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService implements IPatientService {
    private final List<Patient> patients;
    private int cntPatients = 0;

    public PatientService() {
        patients = new ArrayList<>();
        savePatient(Patient.builder()
                .firstName("Patient")
                .lastName("Zero")
                .birthDate(LocalDate.of(1997, 4, 17))
                .build());
    }

    @Override
    public Patient getPatientById(int id) {
        return patients.stream().filter(patient -> patient.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patients;
    }

    @Override
    public void savePatient(Patient patient) {
        patient.setId(++cntPatients);
        patients.add(patient);
    }

    @Override
    public void updatePatient(Patient patient) {
        Patient oldPatient = getPatientById(patient.getId());
        if (oldPatient != null) {
            oldPatient.setFirstName(patient.getFirstName());
            oldPatient.setLastName(patient.getLastName());
            oldPatient.setBirthDate(patient.getBirthDate().toString());
        }
    }

    @Override
    public void deletePatient(int id) {
        patients.removeIf(p -> p.getId() == id);
    }

    public List<Patient> getPatientsByName(String name) {
        return patients.stream().filter(p ->
                        p.getLastName().toLowerCase().contains(name.toLowerCase()) ||
                        p.getFirstName().toLowerCase().contains(name.toLowerCase())
        ).toList();
    }
}
