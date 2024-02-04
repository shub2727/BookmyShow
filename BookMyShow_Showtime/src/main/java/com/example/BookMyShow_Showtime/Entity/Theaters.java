package com.example.BookMyShow_Showtime.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

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

    private Integer seatingCapacity;

    private List<String> seatType;


    private List <Integer> screens;
}
