package com.tourconnect.controller;

import com.tourconnect.model.Tour;
import com.tourconnect.repository.TourRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/repo")
    public String repoType() {
        return tourRepository.getClass().getName();
    }
}
