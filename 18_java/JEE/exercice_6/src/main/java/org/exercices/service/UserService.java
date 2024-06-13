package org.exercices.service;

import org.exercices.entity.User;
import org.exercices.repository.impl.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserService {
    private UserRepository userRepository;
    private final SessionFactory sessionFactory;
    private Session session;

    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User register(String username, String email, String password) {
        User user = new User(email, username, password);
        session = sessionFactory.openSession();
        userRepository = new UserRepository(session);
        session.beginTransaction();
        try {
            userRepository.create(user);
            session.getTransaction().commit();
            return user;
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    public boolean login(String email, String password) {
        session = sessionFactory.openSession();
        userRepository = new UserRepository(session);
        try {
            return userRepository.findByEmail(email).getPassword().equals(password);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            session.close();
        }
    }
}
