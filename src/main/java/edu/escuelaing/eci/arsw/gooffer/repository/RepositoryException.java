package edu.escuelaing.eci.arsw.gooffer.repository;

public class RepositoryException extends Exception {

    public RepositoryException(String message) {
            super(message);
    }

    public RepositoryException(Throwable cause) {
        super(cause);
    }

    public RepositoryException(String message, Throwable cause) {
            super(message, cause);
    }
}
