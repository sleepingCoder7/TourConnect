package com.tourconnect.controller;

import com.tourconnect.model.Tour;
import com.tourconnect.repository.TourRepository;
import com.tourconnect.service.TourService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tours")
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }

    @GetMapping("/{tourId}")
    public Tour getTourById(@PathVariable Integer tourId) {
        return tourService.getTourById(tourId);
    }

    @PostMapping
    public String createTour(@RequestBody Tour tour) {
        tourService.createTour(tour);
        return "Tour created successfully";
    }

    @PutMapping
    public String updateTour(@PathVariable Integer tourId, @RequestBody Tour tour) {
        tourService.updateTour(tourId, tour);
        return "Tour updated successfully";
    }

    @DeleteMapping("/{tourId}")
    public String deleteTour(@PathVariable Integer tourId) {

        tourService.deleteTour(tourId);

        return "Tour deleted successfully";
    }

}
