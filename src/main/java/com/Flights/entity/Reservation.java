package com.Flights.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "reservation")
public class Reservation extends EntityClass{

    @Column(name = "checkedIn", nullable = false)
    private boolean checkedIn;

    @Column(name = "numberOfBags", nullable = false)
    private int numberOfBags;

    @OneToOne
    private Passenger passenger;

    @OneToOne
    private Flight flight;
}
