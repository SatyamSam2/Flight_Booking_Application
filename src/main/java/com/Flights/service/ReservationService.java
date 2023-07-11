package com.Flights.service;

import com.Flights.payload.ReservationDto;

public interface ReservationService {

    ReservationDto addReservation(long flightId, long passengerId, ReservationDto reservationDto);


}
