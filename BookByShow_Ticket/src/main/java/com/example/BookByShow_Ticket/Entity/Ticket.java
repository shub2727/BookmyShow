package com.example.BookByShow_Ticket.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Ticket {
    @Id
    private String TicketId;

    private String bookingId;

    @Transient
    private Booking booking;


}
