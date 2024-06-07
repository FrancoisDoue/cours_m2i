package org.bdd_exo_1.repository.impl;

import org.bdd_exo_1.entity.Account;
import org.bdd_exo_1.repository.ARepository;

import java.util.List;

public class AccountRepository extends ARepository<Account> {
    @Override
    public Account get(int id) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return List.of();
    }

    @Override
    public Account create(Account account) {
        return null;
    }

    @Override
    public void update(Account account) {

    }

    @Override
    public void delete(int id) {

    }

}
