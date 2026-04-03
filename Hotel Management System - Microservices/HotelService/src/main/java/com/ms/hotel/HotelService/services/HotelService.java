package com.ms.hotel.HotelService.services;

import com.ms.hotel.HotelService.entities.Hotel;
import com.ms.hotel.HotelService.repositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;


    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    public List<Hotel> getALl() {
        return hotelRepository.findAll();
    }

    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResolutionException("Hotel with given id not found"));
    }
}
