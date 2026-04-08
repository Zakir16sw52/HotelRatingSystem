package com.zhk.rating.entities.services;

import com.zhk.rating.entities.Ratings;
import com.zhk.rating.repositries.RatingRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingServices {
    public Ratings createRating(Ratings rating);
    public List<Ratings> getAllRatings();
    public List<Ratings> getRatingsByHotelId(String hotelId);
    public List<Ratings> getRatingsByUserId(String userId);
}
