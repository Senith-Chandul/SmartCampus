package com.smartroom.exceptions;

public class RoomNotEmptyException extends RuntimeException {

    public RoomNotEmptyException(String msg) {
        super(msg);
    }

}
