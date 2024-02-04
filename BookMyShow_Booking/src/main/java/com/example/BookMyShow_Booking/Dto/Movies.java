package com.example.BookMyShow_Booking.Dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Movies implements Serializable {
    private String movieId;
    private String name;

    private String category;
    private List<String> genre;
    private String rating;
    private List<String> language;
    private String poster;



}
