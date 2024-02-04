package com.example.BookMyShow_Booking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class BookSeats {
    @Id
    private String id;
    private String theaterId;
    private String showTimeId;
    private boolean isBooked;
    private String bookingId;
    private String movieId;
    private List<String> seat;
    private LocalDateTime lockExpirationTime;




    // Getters and setters...
}