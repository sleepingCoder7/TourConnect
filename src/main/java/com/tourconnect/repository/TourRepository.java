package com.tourconnect.repository;

import com.tourconnect.model.Tour;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TourRepository extends MongoRepository<Tour,String> {
}
