package com.example.BookByShow_Ticket.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data

public class Booking {


    private String bookingId;

    private String userId;
    private String theaterId;
    private String showTimeId;
    private String movieId;
    private Double totalAmount;
    private String status;
    private List<String> seats;
    private String moviess;
    private String theater;
    private String userss;
    private String showTimes;


    private Movies movies;

    private Theaters theaters;

    private User user;

    private ShowTime showTime;











}
