package com.Flights.service;

import com.Flights.entity.Flight;
import com.Flights.payload.FlightDto;
import com.Flights.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService{

    private FlightRepository flightRepository;
    private ModelMapper modelMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, ModelMapper modelMapper ) {
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public FlightDto saveFlight(FlightDto flightDto) {
        modelMapper = new ModelMapper();

        Flight flight = modelMapper.map(flightDto, Flight.class);

        Flight savedFlight = flightRepository.save(flight);

        FlightDto savedFlightDto = modelMapper.map(savedFlight, FlightDto.class);

        return savedFlightDto;
    }

    @Override
    public List<FlightDto> searchFlights(String departureCity, String arrivalCity, String dateOfDeparture) {
        List<Flight> flights = flightRepository.findByDepartureCityAndArrivalCityAndDateOfDeparture(
                departureCity, arrivalCity, dateOfDeparture);

        return flights.stream()
                .map(flight -> modelMapper.map(flight, FlightDto.class))
                .collect(Collectors.toList());
    }
}
