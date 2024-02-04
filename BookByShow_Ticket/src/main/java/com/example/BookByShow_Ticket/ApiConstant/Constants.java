package com.example.BookByShow_Ticket.ApiConstant;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Constants {

    private String bookingId;


    private String userID;
    private String name;
    private String userName;
    private String email;

    private Double totalAmount;
    private String status;

    private List<String> seats;

    private String movieId;
    private String movieName;
    private String category;
    private List<String> genre;
    private String rating;
    private List<String> language;
    private String poster;

    private String showtimeID;
    private String startTime;
    private LocalDate showDate;


    private String theaterId;
    private String theatername;
    private String location;
    private List <Integer> screens;






}
