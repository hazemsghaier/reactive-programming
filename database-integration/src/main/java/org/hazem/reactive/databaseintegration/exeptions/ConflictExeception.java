package org.hazem.reactive.databaseintegration.exeptions;

public class ConflictExeception extends RuntimeException {
    public ConflictExeception(String message) {
        super(message);
    }
}
