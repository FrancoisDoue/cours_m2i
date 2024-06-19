package exercice_6.repository.impl;

import exercice_6.entity.User;
import exercice_6.repository.Repository;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserRepository extends Repository<User> {

    public UserRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User find(int id) {
        session = sessionFactory.openSession();
        User u = session.get(User.class, id);
        session.close();
        return u;
    }

    @Override
    public List<User> findAll() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
