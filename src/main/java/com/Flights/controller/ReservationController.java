package com.Flights.controller;


import com.Flights.payload.ReservationDto;
import com.Flights.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/{flightId}/{passengerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ReservationDto> addReservation(
            @PathVariable("flightId") long flightId,
            @PathVariable("passengerId") long passengerId,
            @RequestBody ReservationDto reservationDto
    ) {
        ReservationDto createdReservation = reservationService.addReservation(flightId, passengerId, reservationDto);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

}
