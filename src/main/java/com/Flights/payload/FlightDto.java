package com.Flights.payload;

import lombok.Data;

@Data
public class FlightDto {

    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;
    private String dateOfDeparture;
    private String estimatedDepartureTime;
}
