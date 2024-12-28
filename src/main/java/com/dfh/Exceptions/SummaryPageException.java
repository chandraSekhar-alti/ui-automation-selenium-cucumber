package com.dfh.Exceptions;

public class SummaryPageException extends RuntimeException {

    // Constructor with a custom message
    public SummaryPageException(String message) {
        super(String.format("Exception occurred in RegisterPage" + message));
    }

    // Constructor with a custom message and a cause (another exception)
    public SummaryPageException(String message, Throwable cause) {
        super(String.format("RegisterPage Exception: %s", message), cause);
    }

    // Constructor with only a cause (another exception)
    public SummaryPageException(Throwable cause) {
        super("Exception occurred in RegisterPage.", cause);
    }
}
