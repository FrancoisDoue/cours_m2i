package org.bdd_exo_1.exception;

public class AccountNotLoggedException extends RuntimeException {
    public AccountNotLoggedException(String msg) {
        super(msg);
    }
}
