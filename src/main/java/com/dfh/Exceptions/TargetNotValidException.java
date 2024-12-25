package com.dfh.Exceptions;

public class TargetNotValidException extends RuntimeException {
    public TargetNotValidException(String target) {
        super(String.format("Target %s not supported. use either local or grid", target));
    }
}
