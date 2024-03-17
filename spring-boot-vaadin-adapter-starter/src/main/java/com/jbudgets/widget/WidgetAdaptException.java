package com.jbudgets.widget;

public class WidgetAdaptException extends RuntimeException {
    public WidgetAdaptException() {
        super();
    }

    public WidgetAdaptException(String message) {
        super(message);
    }

    public WidgetAdaptException(String message, Throwable cause) {
        super(message, cause);
    }

    public WidgetAdaptException(Throwable cause) {
        super(cause);
    }

    protected WidgetAdaptException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
