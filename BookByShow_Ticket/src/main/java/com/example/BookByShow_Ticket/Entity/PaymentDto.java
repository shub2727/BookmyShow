package com.example.BookByShow_Ticket.Entity;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class PaymentDto {

    private String paymentID;
    private String bookingID;
    private String userID;
    private String paymentStatus;
    private LocalDateTime timestamp;
}
