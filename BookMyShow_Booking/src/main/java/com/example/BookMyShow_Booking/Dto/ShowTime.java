package com.example.BookMyShow_Booking.Dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class ShowTime implements Serializable {


    private String showtimeID;
    private String startTime;
  //  private LocalDate showDate;
    private String endTime;

    private List<String> movieIdList;
    private List<String> thetarIdList;






    private List<Movies> moviesList ;



}
