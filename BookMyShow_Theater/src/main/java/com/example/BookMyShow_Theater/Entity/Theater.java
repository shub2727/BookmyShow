package com.example.BookMyShow_Theater.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Theater {

    @Id
    private String theaterId;

    private String name;

    private String location;

    private Integer seatingCapacity;

    private List<String> seats;

    private List<Double> seatsRate;

    private List<String> seatType;


    private List <Integer> screens;

}
