package edu.escuelaing.eci.arsw.gooffer.services;

public class ServicesException extends Exception {

        public ServicesException(String message) {
            super(message);
        }

        public ServicesException(Throwable cause) {
            super(cause);
        }

        public ServicesException(String message, Throwable cause) {
            super(message, cause);
        }
}
