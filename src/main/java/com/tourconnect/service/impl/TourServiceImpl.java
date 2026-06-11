package com.tourconnect.service.impl;

import com.tourconnect.exception.DuplicateTourException;
import com.tourconnect.exception.TourNotFoundException;
import com.tourconnect.model.Tour;
import com.tourconnect.repository.TourRepository;
import com.tourconnect.service.TourService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourServiceImpl implements TourService {

    private final TourRepository tourRepository;

    public TourServiceImpl(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @Override
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @Override
    public Tour getTourById(Integer tourId) {
        return tourRepository.findByTourId(tourId).orElseThrow(() -> new TourNotFoundException(tourId));
    }

    @Override
    public void createTour(Tour tour) {
        if(tourRepository.existsByTourId(tour.getTourId())) {
            throw new DuplicateTourException(tour.getTourId());
        }
        tourRepository.save(tour);
    }

    @Override
    public void updateTour(Integer tourId, Tour tour) {
        Tour existingTour = tourRepository.findByTourId(tourId).orElseThrow(() -> new TourNotFoundException(tourId));

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
        Tour existingTour = tourRepository.findByTourId(tourId).orElseThrow(() -> new TourNotFoundException(tourId));

        tourRepository.delete(existingTour);
    }
}
