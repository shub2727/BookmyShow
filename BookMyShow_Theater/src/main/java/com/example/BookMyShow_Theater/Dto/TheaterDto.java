package com.example.BookMyShow_Theater.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NonNull;

import java.util.List;


@Data
public class TheaterDto {


    private String theaterId;


    @NotEmpty
    private String name;

    @NotEmpty
    private String location;

    @NotEmpty
    private Integer seatingCapacity;
    @NotEmpty
    private List<String> seatType;

    @NotEmpty
    private List <Integer> screens;

    private List<String> seats;

    private List<Double> seatsRate;

}
