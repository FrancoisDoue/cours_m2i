package tp_hopital.wep_application.service;

import tp_hopital.shared.repository.impl.AccountRepository;
import tp_hopital.shared.util.HibernateManager;

public class AuthService {

    AccountRepository accountRepository;

    public AuthService() {
        this.accountRepository = new AccountRepository(HibernateManager.getFactory());
    }

    public boolean login(String login, String password) {
        return accountRepository.findByLogin(login)
                .getPassword().equals(password);
    }




}
