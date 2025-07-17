package org.hazem.reactive.databaseintegration.exeptions;

public class OperationTimeoutException extends RuntimeException {
    public OperationTimeoutException(String message) {
        super(message);
    }
}
