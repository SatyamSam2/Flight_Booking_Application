package com.Flights.service;

import com.Flights.payload.FlightDto;

import java.util.List;

public interface FlightService {

    FlightDto saveFlight(FlightDto flightDto);

    List<FlightDto> searchFlights(String departureCity, String arrivalCity, String dateOfDeparture);

}
