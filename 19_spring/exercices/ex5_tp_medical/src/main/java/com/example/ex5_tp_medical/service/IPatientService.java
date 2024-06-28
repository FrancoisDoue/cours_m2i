package com.example.ex5_tp_medical.service;

import com.example.ex5_tp_medical.model.Patient;

import java.util.List;

public interface IPatientService {
    Patient getPatientById(int id);
    List<Patient> getAllPatients();
    void savePatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(int id);
}
