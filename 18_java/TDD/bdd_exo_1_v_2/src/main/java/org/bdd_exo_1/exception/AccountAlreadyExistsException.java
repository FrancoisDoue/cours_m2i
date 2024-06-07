package org.bdd_exo_1.exception;

public class AccountAlreadyExistsException extends RuntimeException {
    public AccountAlreadyExistsException(String msg) {
        super(msg);
    }
}
