package com.tourconnect.repository;

import com.tourconnect.model.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TourRepository extends MongoRepository<Tour,String> {
    Optional<Tour> findByTourId(Integer tourId);

    boolean existsByTourId(Integer tourId);

    void deleteByTourId(Integer tourId);
}
