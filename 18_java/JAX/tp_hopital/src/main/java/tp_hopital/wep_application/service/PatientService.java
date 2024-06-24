package tp_hopital.wep_application.service;

import tp_hopital.shared.entity.Patient;
import tp_hopital.shared.repository.impl.PatientRepository;
import tp_hopital.shared.util.HibernateManager;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService() {
        patientRepository = new PatientRepository(HibernateManager.getFactory());
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(int id) {
        return patientRepository.find(id);
    }

    public Patient createPatient(String firstname, String lastname, String date, String imageUrl) {
        try {
            Patient patient = Patient.builder()
                    .firstname(firstname)
                    .lastname(lastname)
                    .dateOfBirth(LocalDate.parse(date))
                    .build();
            if (imageUrl != null) patient.setPhotoUrl(imageUrl);
            patientRepository.create(patient);
            return patient;
        } catch (DateTimeParseException e) {
            System.out.println("Error creating patient : " + e.getMessage());
            return null;
        }
    }
}
