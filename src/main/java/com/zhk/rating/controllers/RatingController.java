package com.zhk.rating.controllers;

import com.zhk.rating.entities.Ratings;
import com.zhk.rating.entities.services.RatingServices;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingServices ratingService;

    private org.slf4j.Logger logger= org.slf4j.LoggerFactory.getLogger(RatingController.class);
    @PostMapping("")
    public ResponseEntity<Ratings> createRating(@RequestBody Ratings rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Ratings>> getAllRatings(){
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<Ratings>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<Ratings>> getRatingsByUserId(@PathVariable String userId){
        List<Ratings> ratingList=ratingService.getRatingsByUserId(userId);
        logger.info("Rating List",ratingList);
        return ResponseEntity.ok(ratingList);
    }
}
