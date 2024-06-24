package tp_hopital.shared.repository.impl;

import org.hibernate.SessionFactory;
import tp_hopital.shared.entity.Consultation;
import tp_hopital.shared.entity.Patient;
import tp_hopital.shared.repository.AbstractRepository;

import java.util.List;

public class ConsultationRepository extends AbstractRepository<Consultation> {

    public ConsultationRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Consultation find(int id) {
        session = sessionFactory.getCurrentSession();
        Consultation consultation = session.get(Consultation.class, id);
        session.close();
        return consultation;
    }

    public List<Consultation> findAllByPatient(Patient patient) {
        session = sessionFactory.getCurrentSession();
        List<Consultation> consultations = session.createQuery("FROM Consultation WHERE patient = :patient", Consultation.class)
                .setParameter("patient", patient).list();
        session.close();
        return consultations;
    }

    @Override
    public List<Consultation> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
