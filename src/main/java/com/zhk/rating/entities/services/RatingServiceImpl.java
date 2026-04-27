package com.zhk.rating.entities.services;

import com.zhk.rating.controllers.RatingController;
import com.zhk.rating.entities.Ratings;
import com.zhk.rating.repositries.RatingRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingServices{


    private org.slf4j.Logger logger= org.slf4j.LoggerFactory.getLogger(RatingServiceImpl.class);
    @Autowired
    private RatingRepositry ratingRepositry;
    @Override
    public Ratings createRating(Ratings rating) {
        return ratingRepositry.save(rating);
    }

    @Override
    public List<Ratings> getAllRatings() {
        return ratingRepositry.findAll();
    }

    @Override
    public List<Ratings> getRatingsByHotelId(String hotelId) {
        return ratingRepositry.findRatingsByHotelId(hotelId);
    }

    @Override
    public List<Ratings> getRatingsByUserId(String userId) {
        List<Ratings> ratingsList= ratingRepositry.findRatingsByUserId(userId);
        logger.info("Rating List",ratingsList);
        return ratingsList;
    }
}
