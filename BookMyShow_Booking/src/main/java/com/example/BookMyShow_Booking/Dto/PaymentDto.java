package com.example.BookMyShow_Booking.Dto;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class PaymentDto {

    private String paymentID;
    private String bookingID;
    private String userID;
    private String cardNumber;
    private String cardHolderName;
    private String cardExpire;
    private String cardCvv;
    private Double totalAmount;
    private String paymentStatus;
    private LocalDateTime timestamp;

}
