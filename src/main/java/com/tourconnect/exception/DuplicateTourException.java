package com.tourconnect.exception;

public class DuplicateTourException extends RuntimeException {
    public DuplicateTourException(Integer  tourId) {
        super("Tour with ID " + tourId + " already exists");
    }
}
