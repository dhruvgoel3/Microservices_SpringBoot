package com.ms.rating.HotelRating.services;

import com.ms.rating.HotelRating.entities.Rating;
import com.ms.rating.HotelRating.repositories.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {

    private final RatingRepository ratingRepository;

    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    public List<Rating> getRatingUserId(Integer userId) {
        return ratingRepository.findByUserId(userId);

    }

    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);

    }
}
