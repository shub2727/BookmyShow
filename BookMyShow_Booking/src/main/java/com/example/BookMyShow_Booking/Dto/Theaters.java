package com.example.BookMyShow_Booking.Dto;

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









}
