package com.zhk.rating.controllers;

import com.zhk.rating.entities.Ratings;
import com.zhk.rating.entities.services.RatingServices;
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
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }
}
