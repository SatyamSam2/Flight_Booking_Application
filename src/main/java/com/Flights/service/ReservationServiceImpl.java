package com.Flights.service;


import com.Flights.entity.Flight;
import com.Flights.entity.Passenger;
import com.Flights.entity.Reservation;
import com.Flights.exceptions.ResourceNotFoundException;
import com.Flights.payload.ReservationDto;
import com.Flights.repository.FlightRepository;
import com.Flights.repository.PassengerRepository;
import com.Flights.repository.ReservationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final PassengerRepository passengerRepository;
    private final FlightRepository flightRepository;

    @Autowired
    public ReservationServiceImpl(
            ReservationRepository reservationRepository,
            PassengerRepository passengerRepository,
            FlightRepository flightRepository
    ) {
        this.reservationRepository = reservationRepository;
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    public ReservationDto addReservation(long flightId, long passengerId, ReservationDto reservationDto) {

        Passenger passenger = passengerRepository.findById(passengerId).orElseThrow(() ->
                new ResourceNotFoundException("Passenger with ID " + passengerId + " does not exist.")
        );

        Flight flight = flightRepository.findById(flightId).orElseThrow(() ->
                new ResourceNotFoundException("Flight with ID " + flightId + " does not exist.")
        );

        Reservation reservation = new Reservation();
        BeanUtils.copyProperties(reservationDto, reservation);
        reservation.setPassenger(passenger);
        reservation.setFlight(flight);

        Reservation savedReservation = reservationRepository.save(reservation);

        return mapToReservationDto(savedReservation);
    }

    private ReservationDto mapToReservationDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        BeanUtils.copyProperties(reservation, reservationDto);
        return reservationDto;
    }

}
