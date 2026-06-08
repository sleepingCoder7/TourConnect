package com.tourconnect.controller;

import com.tourconnect.model.Tour;
import com.tourconnect.repository.TourRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TourController {

    private final TourRepository tourRepository;

    public TourController(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    @GetMapping("/tours")
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    @GetMapping("/tours/{id}")
    public Tour getTour(@PathVariable String id) {
        return tourRepository.findById(id).orElseThrow();
    }

    @PostMapping("/tours")
    public Tour createTour(@Valid @RequestBody Tour tour) {
        return tourRepository.save(tour);
    }

    @DeleteMapping("/tours/{id}")
    public void deleteTour(@PathVariable String id) {
        tourRepository.deleteById(id);
    }

    @GetMapping("/tours/search")
    public List<Tour> searchTours(@RequestParam String title) {
        return tourRepository.findByTitle(title);
    }
}
