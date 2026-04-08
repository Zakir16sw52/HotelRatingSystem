package com.zhk.rating.repositries;

import com.zhk.rating.entities.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepositry extends MongoRepository<Ratings,String> {

    List<Ratings> findRatingsByUserId(String userId);
    List<Ratings> getRatingsByHotelId(String hotelId);
    List<Ratings> findRatingsByHotelId(String hotelId);
}
