package tp_hopital.shared.repository.impl;

import org.hibernate.SessionFactory;
import tp_hopital.shared.entity.Doctor;
import tp_hopital.shared.repository.AbstractRepository;

import java.util.List;

public class DoctorRepository extends AbstractRepository<Doctor> {

    public DoctorRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Doctor find(int id) {
        session = sessionFactory.openSession();
        Doctor doctor = session.get(Doctor.class, id);
        session.close();
        return doctor;
    }

    @Override
    public List<Doctor> findAll() {
        session = sessionFactory.openSession();
        List<Doctor> doctors = session.createQuery("from Doctor", Doctor.class).list();
        session.close();
        return doctors;
    }
}
