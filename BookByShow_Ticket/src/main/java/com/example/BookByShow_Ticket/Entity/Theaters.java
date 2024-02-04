package com.example.BookByShow_Ticket.Entity;

import lombok.*;

import java.io.Serializable;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Theaters implements Serializable {

    private String theaterId;

    private String name;

    private String location;

    private List <Integer> screens;

    private Integer seatingCapacity;

    private List<String> seatType;


    private List<String> seats;

    private List<Double> seatsRate;



}
