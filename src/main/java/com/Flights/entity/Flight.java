package com.Flights.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "flight",
        uniqueConstraints = @UniqueConstraint(columnNames = {"flightNumber", "operatingAirlines"})
)
public class Flight extends EntityClass{

    @Column(name = "flightNumber", nullable = false)
    private String flightNumber;

    @Column(name = "operatingAirlines", nullable = false)
    private String operatingAirlines;

    @Column(name = "departureCity", nullable = false)
    private String departureCity;

    @Column(name = "arrivalCity", nullable = false)
    private String arrivalCity;

    @Column(name = "dateOfDeparture", nullable = false)
    private String dateOfDeparture;

    @Column(name = "estimatedDepartureTime", nullable = false)
    private String estimatedDepartureTime;
}
