package com.example.BookMyShow_Showtime.Dto;

import com.example.BookMyShow_Showtime.Entity.Movies;
import com.example.BookMyShow_Showtime.Entity.Theaters;
import jakarta.persistence.Transient;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ShowTimeDto  {

    private String showtimeID;
    private LocalDate showDate;
    private String startTime;
    private String endTime;
    private List<String> movieIdList;
    private List<String> thetarIdList;

    private List<Movies> moviesList;
    private List<Theaters> theatersList;

}
