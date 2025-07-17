package org.hazem.reactive.databaseintegration.exeptions;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}
