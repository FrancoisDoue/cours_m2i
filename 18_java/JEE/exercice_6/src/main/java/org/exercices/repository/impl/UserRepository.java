package org.exercices.repository.impl;

import org.exercices.entity.User;
import org.exercices.repository.Repository;
import org.hibernate.Session;

import java.util.List;

public class UserRepository extends Repository<User> {

    public UserRepository(Session session) {
        super(session);
    }

    @Override
    public User find(int id) {
        return session.get(User.class, id);
    }

    public User findByEmail(String email) {
        return session.createQuery("from User u where u.email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public List<User> findAll() {
        return session.createQuery("from User", User.class).list();
    }
}
