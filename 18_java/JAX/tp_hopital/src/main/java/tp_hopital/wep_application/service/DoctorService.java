package tp_hopital.wep_application.service;

import tp_hopital.shared.entity.Doctor;
import tp_hopital.shared.repository.impl.DoctorRepository;
import tp_hopital.shared.util.HibernateManager;

import java.util.List;

public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService() {
        this.doctorRepository = new DoctorRepository(HibernateManager.getFactory());
    }

    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(int id) {
        return doctorRepository.find(id);
    }

    public Doctor createDoctor(String login, String password, String firstname, String lastname, String speciality) {
        try {
            Doctor doctor = Doctor.builder()
                    .login(login)
                    .password(password)
                    .firstname(firstname)
                    .lastname(lastname)
                    .speciality(speciality)
                    .build();
            doctorRepository.create(doctor);
            return doctor;
        } catch (RuntimeException e) {
            System.out.println("Error creating doctor : " + e.getMessage());
            return null;
        }
    }
}
