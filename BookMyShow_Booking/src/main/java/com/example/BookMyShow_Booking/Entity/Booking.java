package com.example.BookMyShow_Booking.Entity;

import com.example.BookMyShow_Booking.Dto.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
public class Booking {

    @Id
    private String bookingId;

    private String userId;
    private String theaterId;
    private String showTimeId;
    private String movieId;
    private Double totalAmount;
    private String status;


    private List<String> seats;
    private LocalDate showDate;

    private String moviess;
    private String theater;
    private String userss;
    private String showTimes;

    @ElementCollection
    @CollectionTable(name = "booking_food_mapping", joinColumns = @JoinColumn(name = "booking_id"))
    @MapKeyColumn(name = "food_name")
    @Column(name = "orderdFood")
    private Map<String, Integer> foodName = new HashMap<>();

//    @ElementCollection
//    private Map<String, Integer> foodName = new HashMap<>();

    private String paymentID;
    private String paymentStatus;
    private LocalDateTime timestamp;

    @Transient
    private Movies movies;
    @Transient
    private Theaters theaters;
    @Transient
    private User user;
    @Transient
    private ShowTime showTime;
    @Transient
    private PaymentDto paymentDto;

    @Transient
    private FoodDto foodDto;







}
