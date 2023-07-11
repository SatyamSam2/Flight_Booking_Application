package com.Flights.controller;

import com.Flights.payload.FlightDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.Flights.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    //http://localhost:8080/flights
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FlightDto> saveFlight(@RequestBody FlightDto flightDto) {

        FlightDto savedFlightDto = flightService.saveFlight(flightDto);

        return new ResponseEntity<>(savedFlightDto, HttpStatus.CREATED) ;
    }

    @GetMapping("/search")
    public ResponseEntity<List<FlightDto>> searchFlights(
            @RequestParam String departureCity,
            @RequestParam String arrivalCity,
            @RequestParam String dateOfDeparture) {
        List<FlightDto> flightDtos = flightService.searchFlights(departureCity, arrivalCity, dateOfDeparture);
        return new ResponseEntity<>(flightDtos, HttpStatus.OK);
    }


}
