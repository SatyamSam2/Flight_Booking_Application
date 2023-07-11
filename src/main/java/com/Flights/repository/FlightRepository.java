package com.Flights.repository;

import java.util.Date;
import java.util.List;
import com.Flights.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByDepartureCityAndArrivalCityAndDateOfDeparture(String departureCity, String arrivalCity, String dateOfDeparture);
}