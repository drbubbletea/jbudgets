package com.jbudgets.resource;

public class ClassResourceNotFoundException extends RuntimeException {

    public ClassResourceNotFoundException() {
        super();
    }

    public ClassResourceNotFoundException(String message) {
        super(message);
    }

    public ClassResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClassResourceNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ClassResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
