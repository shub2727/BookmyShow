package com.example.BookMyShow_Booking.ApiConstant;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    private String theaterId;
    private String theatername;
    private String location;
    private List <Integer> screens;

    private Map<String, Integer> foodName = new HashMap<>();

    private String paymentID;
    private String cardNumber;
    private String cardHolderName;
    private String cardExpire;
    private String cardCvv;
    private Double totaPayedAmountt;
    private String paymentStatus;
    private LocalDateTime timestamp;







}
