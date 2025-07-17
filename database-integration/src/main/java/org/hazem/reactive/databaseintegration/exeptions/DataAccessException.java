package org.hazem.reactive.databaseintegration.exeptions;

public class DataAccessException extends RuntimeException {
    public DataAccessException(String message) {
        super(message);
    }
}
