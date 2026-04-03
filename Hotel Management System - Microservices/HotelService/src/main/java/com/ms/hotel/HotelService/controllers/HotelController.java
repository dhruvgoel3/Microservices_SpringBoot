package com.ms.hotel.HotelService.controllers;

import com.ms.hotel.HotelService.entities.Hotel;
import com.ms.hotel.HotelService.services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> create(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.create(hotel);
        return new ResponseEntity<>(createdHotel, HttpStatus.CREATED);
    }


    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId) {
        Hotel response = hotelService.get(hotelId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Hotel>> getAll() {
        List<Hotel> hotels = hotelService.getALl();
        return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
    }
}
