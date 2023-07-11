package com.Flights.service;

import com.Flights.entity.Passenger;
import com.Flights.payload.PassengerDto;
import com.Flights.repository.PassengerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, ModelMapper modelMapper) {
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
    }
    
    @Override
    public PassengerDto addPassenger(PassengerDto passengerDto) {
        Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
        passenger = passengerRepository.save(passenger);
        return modelMapper.map(passenger, PassengerDto.class);
    }
}
