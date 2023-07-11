package com.Flights.controller;



import com.Flights.payload.PassengerDto;
import com.Flights.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PassengerDto> addPassenger(@Valid @RequestBody PassengerDto passengerDto) {
        PassengerDto createdPassenger = passengerService.addPassenger(passengerDto);
        return new ResponseEntity<>(createdPassenger, HttpStatus.CREATED);
    }
}
