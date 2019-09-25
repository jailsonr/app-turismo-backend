package com.tourismApp.tourismAppBackEnd.repositories;

import com.tourismApp.tourismAppBackEnd.models.*;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourRepository extends MongoRepository<Tour, String>{

}
