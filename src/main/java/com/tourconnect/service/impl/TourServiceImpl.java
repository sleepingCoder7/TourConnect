package com.tourconnect.service.impl;

import com.tourconnect.model.Tour;
import com.tourconnect.repository.TourRepository;
import com.tourconnect.service.TourService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getTourById(Integer tourId) {
        return tourRepository.findByTourId(tourId).orElseThrow(() -> new RuntimeException("Tour not found"));
    }

    @Override
    public void createTour(Tour tour) {
        if(tourRepository.existsByTourId(tour.getTourId())) {
            throw new RuntimeException("Tour with this ID already exists");
        }
        tourRepository.save(tour);
    }

    @Override
    public void updateTour(Integer tourId, Tour tour) {
        Tour existingTour = tourRepository.findByTourId(tourId).orElseThrow(() -> new RuntimeException("Tour not found"));

        existingTour.setTitle(tour.getTitle());
        existingTour.setDescription(tour.getDescription());
        existingTour.setPickup(tour.getPickup());
        existingTour.setMeetingPoint(tour.getMeetingPoint());
        existingTour.setDropOff(tour.getDropOff());
        existingTour.setDuration(tour.getDuration());
        existingTour.setDurationUnit(tour.getDurationUnit());

        tourRepository.save(existingTour);
    }

    @Override
    public void deleteTour(Integer tourId) {
        Tour existingTour = tourRepository.findByTourId(tourId).orElseThrow(() -> new RuntimeException("Tour not found"));

        tourRepository.delete(existingTour);
    }
}
