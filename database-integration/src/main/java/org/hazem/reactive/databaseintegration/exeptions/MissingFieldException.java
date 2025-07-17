package org.hazem.reactive.databaseintegration.exeptions;

public class MissingFieldException extends RuntimeException {
    public MissingFieldException(String message) {
        super(message);
    }
}
