package com.example.BookByShow_Payment.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {


    @Id
    private String paymentID;
    private String bookingID;

    private String userID;
    private Double totalAmount;
    private String paymentStatus;


    private String cardNumber;
    private String cardHolderName;
    private String cardExpire;

    private String cardCvv;

    private LocalDateTime localDateTime;
}
