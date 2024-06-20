package tp_hopital.shared.repository.impl;

import org.hibernate.SessionFactory;
import tp_hopital.shared.entity.Account;
import tp_hopital.shared.repository.AbstractRepository;

import java.util.List;

public class AccountRepository extends AbstractRepository<Account> {

    public AccountRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Account find(int id) {
        session = sessionFactory.openSession();
        Account account = session.get(Account.class, id);
        session.close();
        return account;
    }

    public Account findByLogin(String login) {
        session = sessionFactory.openSession();
        Account account = session.createQuery("FROM Account WHERE login = :login", Account.class)
                .setParameter("login", login).getSingleResult();
        session.close();
        return account;
    }

    @Override
    public List<Account> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
