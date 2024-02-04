package com.example.BookMyShow_Booking.Dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class BookingDto {


    private String bookingId;

    private String userId;
    private String theaterId;
    private String showTimeId;
    private String movieId;
    private Double totalAmount;
    private String status;
    private List<String> seats;
    private LocalDate showDate;

    private Movies movies;
    private Theaters theaters;
    private User user;
    private ShowTime showTime;
    private PaymentDto paymentDto;
    private String cardNumber;
    private String cardHolderName;
    private String cardExpire;
    private String cardCvv;

    private String moviess;
    private String theater;
    private String userss;
    private String showTimes;

    private Map<String,Integer> foodName;

    private String paymentID;
    private String paymentStatus;
    private LocalDateTime timestamp;
}
