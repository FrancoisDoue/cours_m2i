package tp_hopital.shared.repository.impl;

import org.hibernate.SessionFactory;
import tp_hopital.shared.entity.Patient;
import tp_hopital.shared.repository.AbstractRepository;

import java.util.List;

public class PatientRepository extends AbstractRepository<Patient> {

    public PatientRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Patient find(int id) {
        session = sessionFactory.openSession();
        Patient patient = session.get(Patient.class, id);
        session.close();
        return patient;
    }

    @Override
    public List<Patient> findAll() {
        session = sessionFactory.openSession();
        List<Patient> patients = session.createQuery("from Patient", Patient.class).list();
        session.close();
        return patients;
    }
}
