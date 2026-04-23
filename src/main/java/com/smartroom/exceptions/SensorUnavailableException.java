package com.smartroom.exceptions;

public class SensorUnavailableException extends RuntimeException {

    public SensorUnavailableException(String msg) {
        super(msg);
    }
}
