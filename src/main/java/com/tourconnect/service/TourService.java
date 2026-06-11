package com.tourconnect.service;

import com.tourconnect.model.Tour;

import java.util.List;

public interface TourService {
    List<Tour> getAllTours();

    Tour getTourById(Integer tourId);

    void createTour(Tour tour);

    void updateTour(Integer tourId, Tour tour);

    void deleteTour(Integer tourId);
}
