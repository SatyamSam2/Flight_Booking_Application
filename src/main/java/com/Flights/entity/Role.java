package com.Flights.entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role extends EntityClass{

    @Column(length = 60)
    private String name;
}