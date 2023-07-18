package com.Flights.repository;

import java.util.List;
import com.Flights.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByDepartureCityAndArrivalCityAndDateOfDeparture(String departureCity, String arrivalCity, String dateOfDeparture);

}