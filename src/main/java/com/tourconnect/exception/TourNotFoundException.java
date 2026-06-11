package com.tourconnect.exception;

public class TourNotFoundException extends RuntimeException{
    public TourNotFoundException(Integer tourId){
        super("Tour with ID " + tourId + " not found");
    }
}
