package com.dfh.Exceptions;

public class HouseholdPageException extends RuntimeException {
    public HouseholdPageException(String message) {
        super(message);
    }


    // Constructor with a custom message and a cause (another exception)
    public HouseholdPageException(String message, Throwable cause) {
        super(String.format("HouseholdPage Exception: %s", message), cause);
    }

    // Constructor with only a cause (another exception)
    public HouseholdPageException(Throwable cause) {
        super("Exception occurred in HouseholdPage.", cause);
    }
}
