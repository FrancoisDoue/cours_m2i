package org.exercices.exercice_4;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String notFoundCity) {
        super(notFoundCity);
    }
}
