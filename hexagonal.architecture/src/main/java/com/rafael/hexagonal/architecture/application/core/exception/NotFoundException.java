package com.rafael.hexagonal.architecture.application.core.exception;

public class NotFoundException extends RuntimeException {
    
    public NotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
    
    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException() {
        super();
    }
}
