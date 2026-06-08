package com.tourconnect.repository;

import com.tourconnect.model.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TourRepository extends MongoRepository<Tour,String> {
    List<Tour> findByTitle(String title);
}
