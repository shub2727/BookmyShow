package com.example.BookByShow_Payment.Dto;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class PaymentDto {

    private String paymentID;
    private String bookingID;
    private String userID;
    private Double totalAmount;
    private String paymentStatus;
    private LocalDateTime localDateTime;

    private String cardNumber;
    private String cardHolderName;
    private String cardExpire;
    private String cardCvv;
}
